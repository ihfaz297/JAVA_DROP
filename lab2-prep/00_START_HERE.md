# win-lab-2: two-night training

**This folder is all you need.** You don't need to open any PDFs, your old folders or the textbook.

```
lab2-prep/
  00_START_HERE.md    ← you are here (the plan)
  01_FOUNDATIONS.md   ← Java from zero: syntax, references, STATIC, constructors, overloading,
                        POLYMORPHISM, NESTED CLASSES, abstract/interfaces. Mental pictures + demos.
  02_INTEL.md         ← how Yeamin sir writes the exam (format, tricks, what he taught this semester)
  03_TUTORIAL.md      ← the 20-min exam method + a real paper walked through + his traps
  04_DRILLS.md        ← 20 predict-the-output questions, answers hidden

  foundations/        ← 6 warm-up papers in HIS format, easier than the real thing, one per concept
     f1/TestTicket.java → write Ticket.java   static
     f2/TestZoo.java    → write Dog.java      polymorphism
     f3/TestHouse.java  → write House.java    nested classes
     f4/TestChain.java  → write Car.java      constructors, super/this, init order
     f5/TestCalc.java   → write Calc.java     overloading, varargs, pass-by-value
     f6/TestShape.java  → write Circle.java   abstract, final, interfaces
  real2022/           ← the ACTUAL 2022 Lab Exam 02, sets A B C D (write A/B/C/D.java)
  mock1/ TestP.java   → write Q.java   exam-level: abstract/super/overload/varargs/inner/hiding
  mock2/ TestK.java   → write K.java   exam-level: match EXPECTED_OUTPUT.txt (init order)
  mock3/ TestM.java   → write M.java   exam-level: inner/nested/anonymous/static/recursion
  mock4/ TestN.java   → write N.java   exam-level: interfaces
  solutions/          ← DON'T open until you've finished (or the timer ran out)
```

How to run any paper (in the VSCode terminal):
```
cd lab2-prep/foundations/f1
javac *.java
java TestTicket
```
Every paper and every demo in these files has been compiled and run. The solutions all score 10/10 on your JDK 23.

**The ladder:** foundations (F) → real 2022 papers → mocks. Each rung is harder than the one before.
The foundation papers use **the exact same format** as the exam, so you're practising the exam move from minute one.

---

## The one thing to understand before starting

This exam isn't "know all of Java". It's **one locked file, about 10 tests, 20 minutes, one class to write**.
It has been the same format across sets and years. You're training for **one move**, repeated until it's automatic.

---

## NIGHT 1: tutorial mode (rebuild the base; slow is fine, understanding is the goal)

| # | Time | Do this |
|---|---|---|
| 1 | 10 min | Skim `02_INTEL.md` §1–§2, just to see the enemy. |
| 2 | 20 min | `01_FOUNDATIONS.md` §0 + §1. **Type** the refresher and run it. |
| 3 | 30 min | §2 **static** → do **F1**. |
| 4 | 30 min | §3 **constructors/init order** → do **F4**. |
| 5 | 25 min | §4 **overloading/varargs** → do **F5**. |
| — | 10 min | Break. Walk. Water. |
| 6 | 45 min | §5 **polymorphism** → do **F2**. Take your time on this one. Say the two-question rule out loud for each test. |
| 7 | 40 min | §6 **nested classes** → do **F3**. |
| 8 | 30 min | §7 **abstract/final/interfaces** → do **F6**. |
| — | | **Sleep.** It sticks overnight, and it doesn't stick on a fried brain. |

Rules for Night 1: no timer pressure. Stuck for more than 5 min on one test? Open the solution, read **only the lines for that test**,
close it, type them yourself. Before sleeping, rerun any F-paper that you peeked on, from blank.

Night 1 goal: **F1–F6 all at 10/10, and you can explain why each test passes.**
If you only get through F2 and F3 (your weak spots) properly, that's still a win. Push the rest to the morning.

---

## NIGHT 2: from tutorial to military

### Phase A: bridge (tutorial, ~1h40)
| # | Time | Do this |
|---|---|---|
| 1 | 10 min | Read `02_INTEL.md` fully. |
| 2 | 30 min | `03_TUTORIAL.md` Part A + B, then **type** the real 2022 Set C solution into a folder with `real2022/TestC.java`. Get 10/10. |
| 3 | 30 min | `04_DRILLS.md`, all 20, honest scoring. For each miss, reread the tag in `03_TUTORIAL.md` Part C / `01_FOUNDATIONS.md`. |
| 4 | 30 min | `real2022/TestD.java` → `D.java`. Timer on, but no penalty. Use the data-point trick. |

### Phase B: military mode
Rules from here on:
- **20-minute hard timer.** When it rings, run the test and record your score. That's your score.
- **No solutions, no notes, no Google.** Only the test file and your editor, like the lab.
- **New empty folder for each attempt**, containing only the `TestX.java`. Small font. Reg-no comment on top (practise the ritual).
- A paper counts as **done** only at **10/10 within 20 min**. Otherwise redo it in the morning from blank.

| # | Paper | Target |
|---|---|---|
| 5 | `mock1/TestP.java` → `Q.java` | 10/10 |
| 6 | `mock3/TestM.java` → `M.java` | 10/10 |
| 7 | `real2022/TestA.java` → `A.java` (interface set) | 10/10 |
| 8 | `mock2/TestK.java` → `K.java`, output identical to `EXPECTED_OUTPUT.txt` | exact match |
| 9 | `mock4/TestN.java` → `N.java` | 10/10 |
| 10 | **Blank-sheet rerun** of whichever paper scored lowest tonight | 10/10 < 15 min |

If time runs short, **drop 9 before 5/6/8.** Interfaces are the least likely topic (see `02_INTEL.md` §4).
If you're past step 8 and still standing, you're done. **Stop and sleep.**
One more hour of practice isn't worth the sleep before a 20-minute exam.

### Morning of the exam (30 min max)
- Reread `02_INTEL.md` §3 (his tricks) and the checklist below.
- Redo `real2022/TestC.java` from blank. It's a confidence rep, aim for < 10 min.

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

It's okay to be frustrated, but the fix is always one of these:
1. **Doesn't compile?** Read the *first* error only. 90% of the time it's a missing `public`, a missing `super(...)`, or a wrong return type.
2. **"cannot find symbol" on a method?** Two-question rule, Q1: does the variable's **declared type** have that method? (`01_FOUNDATIONS.md` §5)
3. **Test fails?** Print the actual value, e.g. `System.out.println(b.m1(20,30));` in a scratch main. Compare it to what the test wants.
4. **Weird numbers?** Check whether an earlier line did `x.i += 10`. Tests mutate state between checks.
5. **`==` fails on a String?** You built a new string instead of storing the one you were given.
6. **Counter off by one?** Count every `new` in `main()` by hand, in order, including ones inside expressions.
7. **"non-static … cannot be referenced from a static context"?** You're in a static method or static nested class touching instance stuff (`01_FOUNDATIONS.md` §2, §6).

---

## Java version note
Your laptop: JDK 23. Sir's own lab code uses Java 25 features (`IO.println`, code before `super()`).
Write `System.out.println` and put `super(...)` first. That works on both. Don't be thrown if the exam file uses `IO.println`.
