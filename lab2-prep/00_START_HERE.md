# win-lab-2: two-night training

```
lab2-prep/
  00_START_HERE.md   ← you are here (the plan)
  01_INTEL.md        ← how he writes the exam. Read FIRST, 10 min.
  02_TUTORIAL.md     ← the 20-min method + every concept + his traps
  03_DRILLS.md       ← 20 predict-the-output questions, answers hidden
  real2022/          ← the ACTUAL 2022 Lab Exam 02, sets A B C D
  mock1/ TestP.java  → you write Q.java   (abstract/super/overload/varargs/inner/hiding)
  mock2/ TestK.java  → you write K.java   (match EXPECTED_OUTPUT.txt: init order)
  mock3/ TestM.java  → you write M.java   (inner/static nested/anonymous/static/recursion)
  mock4/ TestN.java  → you write N.java   (interfaces, in case Sets A/B show up)
  solutions/         ← DON'T open until you've finished (or the timer ran out)
```

How to run any paper:
```
cd lab2-prep/mock1
javac *.java
java TestP
```
Every paper here has been compiled and run. The solutions score 10/10 on JDK 23.

---

## The one thing to understand before starting

This exam isn't "know all of Java". It's **one locked file, about 10 tests, 20 minutes, one class to write**.
It has been the same format across sets and years. Swapping names between sets doesn't change the structure.
You're training for **one move**, repeated until it's automatic.

---

## NIGHT 1: tutorial mode (understand it; being slow is fine)

| # | Time | Do this |
|---|---|---|
| 1 | 15 min | Read `01_INTEL.md`. Just read it. |
| 2 | 30 min | Read `02_TUTORIAL.md` Part A + B. Then open `real2022/TestC.java` and **type** the solution from Part B yourself. Don't paste it. Run it until you get 10/10. |
| 3 | 25 min | `real2022/TestD.java`, same shape, different formulas. **No timer, no solution.** Use the data-point trick for `m1`. Stuck for more than 5 min on one test? Peek at `solutions/real2022/D.java` for that one line only. |
| 4 | 40 min | `02_TUTORIAL.md` Part C (C1–C10). For each section, write a 3-line example in a scratch file and run it. Your fingers need to have typed each of them once. |
| 5 | 30 min | `03_DRILLS.md` D01–D20, honest scoring. Note every miss. |
| 6 | 40 min | **mock1** (write `Q.java`). Timer on, but **no penalty**. Write down how long it took. |
| — | | **Sleep.** Seriously. Night 2 is where it sticks, and it doesn't stick on a fried brain. |

Night 1 goal: **you've done real2022 C + D and mock1, and you know why each test passes.**

---

## NIGHT 2: military mode

Rules from now on:
- **20-minute hard timer.** When it rings, run the test and record your score. That's your score.
- **No solutions, no notes, no Google.** Only the test file and your editor, like the lab.
- **New empty folder for each attempt.** Copy only the `TestX.java` into it. Use a small font, and put a reg-no comment on top (practise the ritual).
- A paper counts as **done** only when you get **10/10 within 20 min**. Otherwise redo it tomorrow morning from blank.

| # | Time | Paper | Target |
|---|---|---|---|
| 1 | 10 min | Reread your drill misses from Night 1 + the "tricks" list in `01_INTEL.md` §3 | — |
| 2 | 20 min | `real2022/TestA.java` → write `A.java` (interface set) | 10/10 |
| 3 | 20 min | `real2022/TestB.java` → `B.java` | 10/10, faster than A |
| 4 | 20 min | **mock3** → `M.java` | 10/10 |
| 5 | 20 min | **mock4** → `N.java` | 10/10 |
| 6 | 20 min | **mock2** → `K.java`, output must match `EXPECTED_OUTPUT.txt` line for line (`fc` or eyeball) | exact match |
| 7 | 15 min | **Blank-sheet rerun:** delete your `Q.java`, redo **mock1** from nothing | < 12 min |
| 8 | 15 min | Blank-sheet rerun of **real2022/TestC** | < 10 min |
| 9 | 10 min | `03_DRILLS.md` again, only the ones you missed | 20/20 |

If you're at step 7 and still standing, you're done. **Stop and sleep.**
An extra hour of practice isn't worth the sleep you'd lose before a 20-minute exam.

---

## Exam-room checklist (read this at the door)

1. Desktop folder = **reg number**. Name + reg in a comment on top of the file.
2. Copy the test file in. **Read all of main() first**, then write the skeleton → **compile at min 5**.
3. `super(...)` first line. `public` on interface methods. `public String toString()`.
4. Numbers without a formula → data-point trick. Try `i`, `x`, `y`, and the constants first.
5. Save → `javac *.java` → `java TestX` after every 2–3 tests.
6. 7/10 that compiles beats 10/10 that doesn't. **Never leave a non-compiling file at the bell.**
7. Time's up: close everything, monitor off, don't shut down the PC.

---

## If you get stuck mid-practice

It's okay to be frustrated, but the fix is always one of these five things:
1. **Doesn't compile?** Read the *first* error only. 90% of the time it's a missing `public`, a missing `super(...)`, or a wrong return type.
2. **Test fails?** Print the actual value: `System.out.println(b.m1(20,30));` in a scratch main. Compare it to what the test wants.
3. **Weird numbers?** Check whether an earlier line did `x.i += 10`. Tests mutate state between checks.
4. **`==` fails on a String?** You built a new string instead of storing the one you were given.
5. **Counter off by one?** Count every `new` in `main()` by hand, in order, including the ones inside expressions.
