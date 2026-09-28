# Tutorial: the 20-minute method, then the concepts

This file assumes you've done `01_FOUNDATIONS.md` (F1–F6). If a Part C section feels shaky, jump back to the matching § there.
What's left after the foundations is **a locked file, a clock, and his specific tricks**. This file handles those.

---

## Part A: the 20-minute algorithm (learn this by heart)

```
min 0-3   READ. Go down the main() line by line and write a skeleton:
          - every "new X(...)"         -> constructor signature
          - every "x.field"            -> field + type
          - every "x.method(args)"     -> method signature + return type
          - every cast / assignment     -> what X extends / implements
min 3-6   SKELETON. Write every member with a dummy body (return 0; return null;).
          COMPILE NOW. javac *.java  ← fix compile errors before any logic.
min 6-15  FILL. Solve each test in order. For number formulas, use the data-point trick (below).
          Recompile + run after every 2-3 tests.
min 15-20 CHECK. Every test "Passed"? Name/reg comment at top? File in the right folder?
```

**Compile early.** A file that compiles and passes 7/10 beats a perfect file that doesn't compile.

### The data-point trick (formula recovery)
The test gives `b.m1(20,30)==85 && b.m1(10,20)==55` with `b.i==5`, and later `a.m1(10,20)==65 && a.m1(10,15)==55` with `a.i==15`.

Guess `m1(x,y) = α·i + β·x + γ·y + δ`:
- same i=15, only y changes by 5 and the result changes by 10, so **γ = 2**
- i=5: x goes 10→20, y goes 20→30, result goes 55→85 (+30 = 10β + 10·2), so **β = 1**
- plug in: 5α + 20 + 60 + δ = 85 and 15α + 10 + 40 + δ = 65, which gives **α = 1, δ = 0**

So `m1 = i + x + 2*y`. Try `i`, `x`, `y`, and the interface constants first. It's always something that simple.

---

## Part B: walkthrough of the real 2022 Set C (`real2022/TestC.java`)

Given in the file:
```java
abstract class A { int i; A(int i){this.i=i;} abstract int m1(int i, int j); }
class B extends C { int j; B(int i,int j){ super(i,"ABCDE"); this.j=j; }
                    String m2(String s){ return s + super.s; }  class D {int k; ...} }
```
Reading `main()` tells you:

| Line in test | What it tells you |
|---|---|
| `B extends C`, `super(i,"ABCDE")` | `C(int i, String s)` exists |
| `super.s` in B, `c.s == "WXY"` | C has a field `String s` |
| `A a = new C(15,"WXY")` | `C extends A`, **not abstract**, so it must implement `m1(int,int)` |
| `c.m1("Ok").equals("**WXY\|\|Ok")` | overload `String m1(String t)` |
| `c.m3(1.1,2.3)`, `c.m3(2.1)`, `c.m3(4 args)` | `double m3(double... d)`, the average |
| `c.m2(25).k == 25` | `m2(int)` returns an object with field `k`, so make an inner class |

The answer (`solutions/real2022/C.java`):
```java
class C extends A {
    String s;
    C(int i, String s) { super(i); this.s = s; }
    int m1(int x, int y) { return i + x + 2 * y; }
    String m1(String t) { return "**" + s + "||" + t; }
    double m3(double... d) { double sum = 0; for (double v : d) sum += v;
                             return Math.round(sum / d.length * 100) / 100.0; }
    class E { int k; E(int k) { this.k = k; } }
    E m2(int k) { return new E(k); }
}
```
Rounding the average to 2 places is a safety net for `==` on doubles. It passes without rounding too, but the rounding costs nothing.

---

## Part C: the concepts, each with the trap he likes

### C1. Constructors, `this()`, `super()`
```java
class P { P(int x) { ... } }          // no P() exists now!
class Q extends P {
    Q(int x, int y) { super(x); ... }  // MUST call super(x): P has no no-arg ctor
    Q(Q o) { this(o.x, o.y); }         // this(...) must be the first statement
}
```
- If the parent has only `P(int)`, then **every** child constructor must call `super(something)`. Otherwise it won't compile.
- A constructor can't call both `this(...)` and `super(...)`.
- Java 25 allows statements before `super()` (he showed this in L06). **Don't rely on it.** Put `super` first.

### C2. Init order: memorise this sequence
```
First use of class:   parent static blocks  →  child static blocks   (ONCE ever)
Every `new Child()`:  parent field inits + instance blocks  →  parent ctor body
                      →  child field inits + instance blocks  →  child ctor body
```
- A `this(...)` chain runs instance blocks **once**, not once per constructor.
- If a parent constructor calls an overridden method, the child's version runs **before** the child's fields are set, so it sees `0` / `null`.
  In Mock 2, `K.show id=0` gets printed even though `id` is declared as `= -1`.

### C3. Overloading vs overriding
| | Overloading | Overriding |
|---|---|---|
| Same name, different **params** | ✔ | ✗ (same params) |
| Chosen by | compile-time arg types | runtime object |
| Return type alone differs | ✗ compile error ("already defined") | must be same/covariant |

- `m(int... )` + `m(String...)` then `m()` gives **"reference to m is ambiguous"** (straight out of L05).
- Exact match wins, then widening (`int→long→double`), then boxing, then varargs.

### C4. Field hiding vs method overriding (his L06 favourite)
```java
class P { int x = 1; int get() { return x; } }
class R extends P { int x = 100; int get() { return x; } }
P p = new R();
p.x      // 1    ← FIELD: declared type P decides
p.get()  // 100  ← METHOD: real object R decides
((R)p).x // 100
```
Inside R, `super.x` is P's x. There's no `super.super.x`; it won't compile.

### C5. static
- A static method has no `this`, so it **can't** touch instance fields ("non-static variable cannot be referenced from a static context").
- A static field is shared by every object. `a.s++` changes `A.s` for everyone.
- Counters like `static int count; ctor: count++`: the tests read the count **at exact moments**, so count *every* constructor call.
  A copy constructor that goes through `this(...)` or `super(...)` counts too.

### C6. Inner vs static nested vs anonymous
```java
class M {
    int side;
    class Inner { int total() { return side + v; } }     // has M.this
    static class Nested { }                               // no outer object
    Shape asShape() { return new Shape() { double area() { return side*side; } }; }
}
M.Inner in = m.new Inner(3);     // needs an outer object
M.Nested n = new M.Nested(5);    // doesn't
```
- An inner class reads the outer fields **live**. If `side` changes, `in.total()` changes.
- An inner class returns its outer object with `M.this`.
- A static nested class can't see instance fields of M.

### C7. Abstract & final
- An abstract class can't be instantiated, but it **can** have constructors, fields and concrete methods.
- A non-abstract child **must** implement every abstract method, or it won't compile.
- `final` method: can't override. `final` class: can't extend. `final` var: assign once.
- An `abstract final` combination is illegal.

### C8. Passing & returning objects
- Primitives are copied, so `doubleIt(v)` leaves `v` unchanged.
- Arrays/objects pass a copy of the **reference**, so `doubleAll(arr)` changes the caller's array.
- A method returning `this` vs another object is a common test: `m.bigger(o) == m`.

### C9. `equals` / `toString` / `==`
- `toString()` must be `public String toString()`. `"" + obj` and `println(obj)` call it.
- `==` compares references. `equals` compares whatever you define. Override `equals(Object o)` properly:
  `return o instanceof M && ((M)o).side == side;`

### C10. Interfaces (insurance for Sets A/B)
- Interface fields are always `public static final`. `B.i`, `B.C.i` are constants.
- Interface methods are `public`, so your implementation **must** write `public`.
- `default` methods can be overridden. To call the original: `Shape2.super.describe()`.
- A `static` interface method is called only as `Shape2.twice(...)`, never through an object.
- A class can `implements B, B.C` (outer interface + nested interface) at the same time.
- If both interfaces have a constant `i` and your class has its own field `i`, then plain `i` means your field. Use `B.i` / `C.i` explicitly.
