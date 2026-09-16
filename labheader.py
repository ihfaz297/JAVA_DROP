#!/usr/bin/env python3
"""
labheader.py - stamps the standard header onto new lab files.

    python labheader.py --watch        # sit in the folder, stamp on create
    python labheader.py --new 07       # create L07_<reg>.java, stamped, and exit
    python labheader.py --stamp F.java # stamp one existing file

Lab number comes from the filename (L07_... -> 07), so it is always right
even if you skip a week or redo one.
"""

import argparse
import json
import os
import re
import sys
import time
from datetime import date

HERE = os.path.dirname(os.path.abspath(__file__))
CONFIG = os.path.join(HERE, "submission_config.json")

# Only files shaped like a lab submission get touched. Scratch files such as
# Test.java or P.java are left alone.
LAB_RE = re.compile(r"^L(\d+)_(\d{10})\.java$", re.I)

HEADER = """/**
 * @LabID: {lab}
 * @Date: {today}
 * @RegNo: {reg}
 * @Section: {section}
 */
"""

SKELETON = """
public class {cls} {{
    public static void main(String[] args) {{

    }}
}}
"""


def cfg():
    try:
        with open(CONFIG, encoding="utf-8") as fh:
            return json.load(fh)
    except (OSError, ValueError):
        return {}


def build_header(filename, reg, section):
    m = LAB_RE.match(os.path.basename(filename))
    lab = m.group(1).zfill(2) if m else "??"
    return HEADER.format(lab=lab, today=date.today().isoformat(),
                         reg=reg, section=section)


def already_stamped(text):
    return "@RegNo" in text[:600]


def stamp(path, reg, section, skeleton=False, quiet=False):
    """Prepend the header. Refuses if the file already has one. -> bool"""
    name = os.path.basename(path)
    try:
        with open(path, "r", encoding="utf-8", errors="replace") as fh:
            body = fh.read()
    except OSError as exc:
        if not quiet:
            print("  skip %s (%s)" % (name, exc))
        return False

    if already_stamped(body):
        if not quiet:
            print("  skip %s (already has a header)" % name)
        return False

    head = build_header(path, reg, section)
    if not body.strip() and skeleton:
        cls = os.path.splitext(name)[0]
        body = SKELETON.format(cls=cls)

    with open(path, "w", encoding="utf-8", newline="") as fh:
        fh.write(head + body)
    print("  stamped %s" % name)
    return True


def watch(folder, reg, section, skeleton=False, interval=1.0):
    """Poll for new lab files and stamp them.

    Polling rather than FileSystemWatcher: a create event can fire before the
    editor has released the handle, and we would read a half-written file.
    Checking for a stable, unstamped file each second has no such race.
    """
    seen = {f for f in os.listdir(folder) if LAB_RE.match(f)}
    print("watching %s" % folder)
    print("  %d lab file(s) already here, leaving them alone" % len(seen))
    print("  create L<nn>_%s.java and it gets stamped. Ctrl-C to stop.\n" % reg)

    while True:
        try:
            current = {f for f in os.listdir(folder) if LAB_RE.match(f)}
        except OSError:
            time.sleep(interval)
            continue

        for name in sorted(current - seen):
            path = os.path.join(folder, name)
            # Let the editor finish writing before we touch it.
            time.sleep(0.4)
            try:
                if os.path.getsize(path) > 4096:
                    # Big file appearing at once is a copy/move, not a new
                    # lab being started. Don't rewrite someone's work.
                    print("  skip %s (not empty - copied in?)" % name)
                    seen.add(name)
                    continue
            except OSError:
                continue
            stamp(path, reg, section, skeleton=skeleton)
            seen.add(name)

        seen = {s for s in seen if s in current}
        time.sleep(interval)


def main():
    sys.stdout.reconfigure(line_buffering=True)
    c = cfg()
    ap = argparse.ArgumentParser(description="Stamp lab headers onto new files.")
    g = ap.add_mutually_exclusive_group(required=True)
    g.add_argument("--watch", action="store_true", help="stamp new files as they appear")
    g.add_argument("--new", metavar="NN", help="create L<NN>_<reg>.java and stamp it")
    g.add_argument("--stamp", metavar="FILE", help="stamp one existing file")
    ap.add_argument("--reg", default=c.get("reg_no"), help="registration number")
    ap.add_argument("--section", default=c.get("section", "B"))
    ap.add_argument("--skeleton", action="store_true",
                    help="also add an empty class + main()")
    args = ap.parse_args()

    if not args.reg:
        ap.error("no --reg given and none in submission_config.json")

    if args.stamp:
        path = args.stamp if os.path.isabs(args.stamp) else os.path.join(HERE, args.stamp)
        return 0 if stamp(path, args.reg, args.section, args.skeleton) else 1

    if args.new:
        name = "L%s_%s.java" % (args.new.zfill(2), args.reg)
        path = os.path.join(HERE, name)
        if os.path.exists(path):
            print("%s already exists - not touching it" % name)
            return 1
        open(path, "w", encoding="utf-8").close()
        stamp(path, args.reg, args.section, skeleton=True)
        print(path)
        return 0

    try:
        watch(HERE, args.reg, args.section, args.skeleton)
    except KeyboardInterrupt:
        print("\nstopped.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
