#!/usr/bin/env python3
"""
lab_submit.py - fault-tolerant submitter for the OOP lab portal.

Watches ONE address you give it, rides out network blips, submits once,
and tells you unambiguously whether it landed.

    python lab_submit.py 10.100.94.157 --file L07_2022331008.java

Run --preflight the night before to catch problems while you can still fix them.
"""

import argparse
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile
import time
from datetime import datetime

try:
    import requests
except ImportError:
    sys.exit("requests is not installed.  Run:  pip install requests")

HERE = os.path.dirname(os.path.abspath(__file__))
CONFIG = os.path.join(HERE, "submission_config.json")
LOGFILE = os.path.join(HERE, "submission_log.txt")

SUCCESS_RE = re.compile(r'<div class="alert alert-success">(.*?)</div>', re.S)
ERROR_RE = re.compile(r'<div class="alert alert-error">(.*?)</div>', re.S)


def log(msg, bell=False):
    stamp = datetime.now().strftime("%H:%M:%S")
    line = "[%s] %s" % (stamp, msg)
    try:
        sys.stdout.write(("\a" if bell else "") + line + "\n")
    except UnicodeEncodeError:
        # The portal's success banner carries an emoji; a cp1252 console
        # cannot render it. Never let cosmetics kill a real submission.
        safe = line.encode("ascii", "replace").decode("ascii")
        sys.stdout.write(("\a" if bell else "") + safe + "\n")
    sys.stdout.flush()
    with open(LOGFILE, "a", encoding="utf-8") as fh:
        fh.write("[%s] %s\n" % (datetime.now().strftime("%Y-%m-%d %H:%M:%S"), msg))


def load_config():
    try:
        with open(CONFIG, encoding="utf-8") as fh:
            return json.load(fh)
    except (OSError, ValueError):
        return {}


# ---------------------------------------------------------------- preflight

def preflight(path, reg_no, compile_check=True):
    """-> (blocking, warnings)

    Blocking covers only what makes a submission impossible or certain to be
    refused by the portal. Everything else is a warning: code that will not
    compile still scores more than code that never arrives.
    """
    blocking, warnings = [], []

    if not os.path.isfile(path):
        log("FAIL  file not found: %s" % path)
        blocking.append("file not found")
        return blocking, warnings

    size = os.path.getsize(path)
    log("ok    file: %s (%d bytes)" % (os.path.basename(path), size))
    if size == 0:
        log("warn  file is empty")
        warnings.append("file is empty")

    if not re.fullmatch(r"\d{10}", reg_no or ""):
        # The portal rejects this outright, so sending it only burns window.
        log("FAIL  reg_no must be exactly 10 digits, got %r" % reg_no)
        blocking.append("bad reg_no")
    else:
        log("ok    reg_no: %s" % reg_no)

    stem = os.path.splitext(os.path.basename(path))[0]
    if reg_no and reg_no not in stem:
        log("warn  filename %r does not contain your reg number"
            % os.path.basename(path))
        warnings.append("filename mismatch")

    if compile_check:
        if shutil.which("javac") is None:
            log("warn  javac not on PATH -- skipping compile check")
        else:
            tmp = tempfile.mkdtemp(prefix="labsubmit_")
            try:
                proc = subprocess.run(["javac", "-d", tmp, path],
                                      capture_output=True, text=True, timeout=90)
                if proc.returncode == 0:
                    log("ok    compiles clean")
                else:
                    log("warn  DOES NOT COMPILE (submitting anyway):")
                    for ln in (proc.stderr or "").strip().splitlines()[:15]:
                        log("        " + ln)
                    warnings.append("does not compile")
            except subprocess.TimeoutExpired:
                log("warn  javac timed out -- skipping compile check")
            finally:
                shutil.rmtree(tmp, ignore_errors=True)

    return blocking, warnings


# ------------------------------------------------------------------ network

FILE_INPUT_RE = re.compile(
    r"""<input[^>]*?type=["']file["'][^>]*?>""", re.I | re.S)
TEXT_INPUT_RE = re.compile(
    r"""<input[^>]*?type=["']text["'][^>]*?>""", re.I | re.S)
NAME_RE = re.compile(r"""name=["']([^"']+)["']""", re.I)

DEFAULT_FIELDS = ("java_file", "reg_no")


def discover_fields(url, timeout):
    """Read the live form and learn what it calls its inputs.

    Sir has renamed the file input at least once (file -> java_file), which
    silently produced "No file selected". Asking the page beats guessing.
    """
    try:
        html = requests.get(url, timeout=timeout).text
    except requests.RequestException:
        return DEFAULT_FIELDS

    def name_of(pattern, fallback):
        m = pattern.search(html)
        if m:
            n = NAME_RE.search(m.group(0))
            if n:
                return n.group(1)
        return fallback

    ffield = name_of(FILE_INPUT_RE, DEFAULT_FIELDS[0])
    rfield = name_of(TEXT_INPUT_RE, DEFAULT_FIELDS[1])
    return ffield, rfield


def probe(url, timeout):
    """True if the host answered with anything at all."""
    try:
        requests.get(url, timeout=timeout)
        return True
    except requests.RequestException:
        return False


def classify(resp):
    """-> (outcome, detail).  outcome in {success, rejected, unknown}"""
    m = SUCCESS_RE.search(resp.text)
    if m:
        return "success", " ".join(m.group(1).split())
    hits = [" ".join(h.split()) for h in ERROR_RE.findall(resp.text)]
    if hits:
        return "rejected", "; ".join(hits)
    return "unknown", "HTTP %d, %d bytes, no alert banner" % (
        resp.status_code, len(resp.text))


def submit_once(url, path, reg_no, timeout, fields=DEFAULT_FIELDS,
                save_body=False):
    """-> (outcome, detail).  Adds outcome 'network' for transport failures."""
    try:
        with open(path, "rb") as fh:
            resp = requests.post(
                url,
                data={fields[1]: reg_no},
                files={fields[0]: (os.path.basename(path), fh)},
                timeout=timeout)
    except requests.RequestException as exc:
        return "network", type(exc).__name__

    outcome, detail = classify(resp)
    if outcome == "unknown" and save_body:
        dest = os.path.join(HERE, "last_response.html")
        try:
            with open(dest, "w", encoding="utf-8", errors="replace") as out:
                out.write(resp.text)
            detail += " (body saved to %s)" % os.path.basename(dest)
        except OSError:
            pass
    return outcome, detail


# --------------------------------------------------------------------- main

def main():
    # Sir's success banner contains an emoji; a cp1252 console would
    # otherwise raise UnicodeEncodeError *after* a successful submit.
    try:
        sys.stdout.reconfigure(encoding="utf-8", errors="replace")
    except (AttributeError, ValueError):
        pass
    cfg = load_config()
    ap = argparse.ArgumentParser(
        description="Watch one address and submit a lab file to it, reliably.")
    ap.add_argument("host", nargs="?", default=cfg.get("host"),
                    help="IP or hostname of the portal, e.g. 10.100.94.157")
    ap.add_argument("--port", type=int, default=cfg.get("port", 5000))
    ap.add_argument("--file", default=cfg.get("file"), help="the .java file")
    ap.add_argument("--reg", default=cfg.get("reg_no"), help="10-digit reg number")
    ap.add_argument("--window", type=float, default=15.0,
                    help="minutes to keep watching (default 15)")
    ap.add_argument("--interval", type=float, default=1.5,
                    help="seconds between probes (default 1.5)")
    ap.add_argument("--timeout", type=float, default=8.0,
                    help="per-request timeout in seconds")
    ap.add_argument("--retries", type=int, default=6,
                    help="submission attempts before giving up")
    ap.add_argument("--preflight", action="store_true",
                    help="run local checks and exit, touching no network")
    ap.add_argument("--no-compile", action="store_true", help="skip javac check")
    args = ap.parse_args()

    if not args.file:
        ap.error("no --file given and none in submission_config.json")
    path = args.file if os.path.isabs(args.file) else os.path.join(HERE, args.file)

    log("=" * 62)
    log("preflight")
    blocking, warnings = preflight(path, args.reg,
                                   compile_check=not args.no_compile)
    if blocking:
        log("CANNOT submit: %s" % "; ".join(blocking))
        return 2
    if warnings:
        log("preflight passed with %d warning(s) -- will submit regardless"
            % len(warnings))
    else:
        log("preflight passed")
    if args.preflight:
        return 6 if warnings else 0

    if not args.host:
        ap.error("no host given and none in submission_config.json")
    url = "http://%s:%d/" % (args.host, args.port)
    deadline = time.monotonic() + args.window * 60.0
    log("watching %s for up to %g min (probe every %gs)"
        % (url, args.window, args.interval))

    while time.monotonic() < deadline:
        if not probe(url, args.timeout):
            time.sleep(args.interval)
            continue

        fields = discover_fields(url, args.timeout)
        if tuple(fields) != DEFAULT_FIELDS:
            log("form fields: file=%r reg=%r (portal differs from default)"
                % fields)
        log("HOST IS UP -- submitting %s" % os.path.basename(path), bell=True)
        for attempt in range(1, args.retries + 1):
            outcome, detail = submit_once(url, path, args.reg, args.timeout,
                                          fields=fields,
                                          save_body=(attempt == args.retries))
            if outcome == "success":
                log("*** SUBMITTED *** %s" % detail, bell=True)
                log("attempt %d of %d" % (attempt, args.retries))
                return 0
            if outcome == "rejected":
                # Server understood us and said no. Retrying identical input
                # will not change its mind -- surface it instead.
                log("REJECTED by portal: %s" % detail, bell=True)
                log("data problem, not a network one -- fix it and rerun")
                return 3
            if outcome == "unknown":
                log("UNRECOGNISED response: %s" % detail, bell=True)
                log("treat as NOT submitted until you have confirmed by eye")
                return 4
            log("attempt %d/%d failed in transit (%s) -- retrying"
                % (attempt, args.retries, detail))
            time.sleep(min(2.0 * attempt, 6.0))

        log("host reachable but all %d attempts failed" % args.retries, bell=True)
        log("NOT submitted -- go submit by hand at %s" % url)
        return 5

    log("window closed after %g min; host never answered" % args.window, bell=True)
    log("NOT submitted. The log above is a timestamped record that you tried.")
    return 1


if __name__ == "__main__":
    try:
        sys.exit(main())
    except KeyboardInterrupt:
        log("interrupted -- NOT submitted")
        sys.exit(130)
