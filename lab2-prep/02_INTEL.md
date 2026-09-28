# Intel file: how Yeamin sir writes lab exams

Evidence: 2022 Lab Exam 02 (sets A–D), 2021 Lab Final (sets A–C), 2022 Lab Exam 01,
and his **current-semester** lab code (`java-lab-codes-2024-batch`, dated Jul–Sep 2026).

## 1. The format (this is basically guaranteed)

> "The file `TestX.java` is provided. You cannot change any code in it.
> Write class `X` in `X.java` so that running `TestX` prints Test #01 … #10 Passed."

- **20 marks, 20 minutes.** You get one locked file with about 10 `tester(...)` lines.
- Some of the classes are already in the test file (an abstract parent, a subclass of YOUR class, an interface).
  You write the **missing class in the middle** of the hierarchy.
- The 2021 final had a variant where you match a printed output instead of passing `tester()` lines
  (static blocks, init blocks, constructor order). Mock 2 practises that.
- 2022 Lab Exam 01 was pattern printing. That was test **1**; you're sitting test **2**.

## 2. Sets A/B and C/D are the same paper with names swapped

| Set | What you write | Concepts |
|---|---|---|
| A / B | class implementing an interface **and its nested interface** | interface constants, `default` override, nested interface, overloading |
| C / D | class in the middle of `abstract A → C → B` | `super(...)`, abstract method impl, overloading (int/String), **varargs**, **inner class returned from a method**, `super.s` |

The formulas change between sets (`i+x+2y` vs `i+x+y-10`, `replace('a','d')` vs `'a','b'`).
**The structure stays the same.** Master the structure and the formulas are simple arithmetic.

## 3. His favourite tricks (seen in the papers AND in this semester's lab code)

1. **Formula hidden in data points.** `m1(20,30)==85 && m1(10,20)==55` gives no formula, just numbers.
   Treat it as a linear system: `m1 = α·i + β·x + γ·y + δ`. Two sets of data points give all four unknowns.
2. **Field hiding vs method overriding.** Fields are picked by the **declared (compile-time) type**.
   Methods are picked by the **actual object**. `super.x` is his favourite way to show this (L06 code: `super.i = 44`).
3. **`==` on Strings** (`b.s == "ABCDE"`). This passes only because literals are interned.
   Store the reference you were given. Never `new String(s)`.
4. **Casting to a sibling type.** `B.C c = (B.C) b;` only works if YOUR class implements both. Watch those casts;
   they tell you what your class must implement.
5. **Mutation between tests.** `a.i += 10;` then the same method must give new values, so
   read fields live and never cache them in the constructor.
6. **Inner class instance returned by a method.** `c.m2(25).k == 25` means you need a
   class with a field `k` and a method `m2(int)` that returns `new Thing(k)`.
7. **Varargs.** `m3(2.1)`, `m3(1.1, 2.3)`, `m3(a,b,c,d)` all on one method means `double m3(double... d)`.
8. **Init order** (Lab 05/06 were full of this): static blocks once per class, parent first; then per `new`:
   parent init blocks → parent constructor body → child field initialisers/init blocks → child constructor body.
   Overridden methods called from a parent constructor see child fields **still at 0/null**.
9. **Interface methods are `public`.** If you forget `public` on the implementing method, it won't compile.
   It's the most common silly loss.

## 4. What this semester's labs covered (= what he's thinking about)

| Lab | Date | Topic | In the test? |
|---|---|---|---|
| L05 | Aug 18 | static vs instance, init blocks, overloading, `this()`, varargs, ambiguity | **YES, core** |
| L06 | Sep 1 | inner vs static nested, `a.new B()`, `super` field hiding, abstract, final, `instanceof`, anonymous class | **YES, core** |
| L07 | Sep 8 | packages, interfaces (default/static/private methods, nested interfaces) | maybe (CH09, but 2022 sets A/B used it) |
| L08 | Sep 15 | exceptions, threads | probably not (outside CH06–08) |

The official targets are CH06 (Classes), CH07 (Methods & Classes), CH08 (Inheritance).
L05 + L06 match those exactly. Interfaces are the wildcard, so Mock 4 covers them.

## 5. Java-version landmine

His code uses `IO.println(...)` and statements **before** `super(...)` in constructors. Both are **Java 25**.
Your laptop has **JDK 23**, where these fail to compile.
- In your own code, stick to `System.out.println` and put `super(...)` first. That works on every version.
- If the provided test file contains `IO.println`, the lab machines run JDK 25, and so does his code. Don't panic.

## 6. Exam-room rules from his papers
- Folder on the Desktop named after your **registration number**. All files go inside it, including package folders.
- Write your name and reg no in a comment at the top of each file.
- Keep class, method and variable names **exactly** as given (case-sensitive).
- Use a small VSCode font. Don't talk. When time's up, close everything, turn the monitor off, and don't shut down the PC.
