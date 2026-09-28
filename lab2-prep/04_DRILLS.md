# Drills: predict the output or the compile error

Rules: **no running the code.** Write your answer, then open the answer.
Every answer below is real `javac`/`java` output. Score yourself: 17+/20 means you're ready.
Every one you get wrong: reread the matching section in `03_TUTORIAL.md` (tag in brackets).

---

**D01** [C4 hiding]
```java
class P { int x = 1; int get() { return x; } }
class R extends P { int x = 100; int get() { return x; } int sup() { return super.x; } }
P p = new R();
System.out.println(p.x + " " + p.get() + " " + ((R) p).x + " " + ((R) p).sup());
```
<details><summary>answer</summary>

`1 100 100 1`. Fields follow the declared type, methods follow the actual object.
</details>

**D02** [C2 init order]
```java
class A { static { print("A-s"); } { print("A-i"); } A() { print("A()"); } }
class B extends A { static { print("B-s"); } { print("B-i"); } B() { print("B()"); } }
new B(); new B();
```
<details><summary>answer</summary>

```
A-s
B-s
A-i
A()
B-i
B()
A-i
A()
B-i
B()
```
The static blocks run only once.
</details>

**D03** [C2 overridden call in parent ctor]
```java
class A { A() { m(); } void m() { print("A.m"); } }
class B extends A { int v = 5; String s = "hi"; void m() { print("B.m " + v + " " + s); } }
new B().m();
```
<details><summary>answer</summary>

```
B.m 0 null
B.m 5 hi
```
During `A()`, B's field initialisers haven't run yet.
</details>

**D04** [C1]
```java
class A { A(int i) { } }
class B extends A { B() { System.out.println("B"); } }
```
<details><summary>answer</summary>

**Compile error:** `constructor A in class A cannot be applied to given types`. The hidden `super()` has no `A()` to call.
</details>

**D05** [C3]
```java
static void m(int... i)    { print("ints"); }
static void m(String... s) { print("strings"); }
m();
```
<details><summary>answer</summary>

**Compile error:** `reference to m is ambiguous` (from his L05).
</details>

**D06** [C3 overload priority]
```java
static void m(long x)    { print("long"); }
static void m(Integer x) { print("Integer"); }
static void m(int... x)  { print("varargs"); }
m(5);
```
<details><summary>answer</summary>

`long`. Order: widening beats boxing, and boxing beats varargs.
</details>

**D07** [C1 + C2]
```java
class C { int n = 0; C() { this(10); n++; } C(int k) { n += k; } { n += 100; } }
System.out.println(new C().n + " " + new C(1).n);
```
<details><summary>answer</summary>

`111 101`. The instance block runs once (before `C(int)`'s body), then 10, then `n++`.
</details>

**D08** [C6]
```java
class Outer { int x = 1;
    class In { int get() { return x; } }
    static class Ne { int get() { return 7; } } }
Outer o = new Outer(); Outer.In i = o.new In(); o.x = 42;
System.out.println(i.get() + " " + new Outer.Ne().get());
```
<details><summary>answer</summary>

`42 7`. The inner class reads the outer field live.
</details>

**D09** [C6]
```java
class Outer { int x = 1; static class Ne { int get() { return x; } } }
```
<details><summary>answer</summary>

**Compile error:** `non-static variable x cannot be referenced from a static context`.
</details>

**D10** [C8]
```java
static void f(int v, int[] arr, StringBuilder sb, String s) { v++; arr[0]++; sb.append("!"); s += "!"; }
int v = 1; int[] arr = {1}; StringBuilder sb = new StringBuilder("x"); String s = "y";
f(v, arr, sb, s); System.out.println(v + " " + arr[0] + " " + sb + " " + s);
```
<details><summary>answer</summary>

`1 2 x! y`. Strings are immutable, so `s += ` makes a new local string.
</details>

**D11** [C5]
```java
class Cnt { static int c; int id; Cnt() { id = ++c; } }
Cnt x = new Cnt(), y = new Cnt(); Cnt z = x; new Cnt();
System.out.println(x.id + " " + y.id + " " + z.id + " " + Cnt.c + " " + y.c);
```
<details><summary>answer</summary>

`1 2 1 3 3`. `z = x` is not a `new`, so it doesn't count.
</details>

**D12** [C6 anonymous + C7]
```java
abstract class S { abstract int f(); int g() { return f() * 2; } }
int k = 4;
S s = new S() { int f() { return k + 1; } };
System.out.println(s.g());
```
<details><summary>answer</summary>

`10`. The anonymous class can read the effectively-final local `k`.
</details>

**D13** [C7]
```java
class A { final void m() { } }
class B extends A { void m() { } }
```
<details><summary>answer</summary>

**Compile error:** `m() in B cannot override m() in A` (from his L06).
</details>

**D14** [C9]
```java
String p = "AB", q = "A" + "B", r = new String("AB"), t = "A"; t += "B";
System.out.println((p == q) + " " + (p == r) + " " + (p == t) + " " + p.equals(r));
```
<details><summary>answer</summary>

`true false false true`. `"A"+"B"` is a compile-time constant, so it's interned. `t += "B"` runs at runtime, so it's a new object.
</details>

**D15** [C10]
```java
interface I { int K = 3; int f(int x); default int g() { return f(K) + 1; } }
class X implements I { int f(int x) { return x * 2; } }
```
<details><summary>answer</summary>

**Compile error:** `f(int) in X cannot implement f(int) in I` (attempting to assign weaker access privileges). **You forgot `public`.** This is the #1 silly loss on Sets A/B.
</details>

**D16** [C10]
```java
interface I { default String hi() { return "I"; } }
class X implements I { public String hi() { return "X+" + I.super.hi(); } }
I i = new X(); System.out.println(i.hi());
```
<details><summary>answer</summary>

`X+I`
</details>

**D17** [C4/C5 static methods don't override]
```java
class A { static void s() { print("A.s"); } void i() { print("A.i"); } }
class B extends A { static void s() { print("B.s"); } void i() { print("B.i"); } }
A x = new B(); x.s(); x.i();
```
<details><summary>answer</summary>

```
A.s
B.i
```
Static methods are *hidden*, not overridden, so the declared type decides.
</details>

**D18** [C4 + C1, the nasty one]
```java
class A { int i = 10; A() { i++; } }
class B extends A { int i = 20; B() { super(); i += super.i; } }
B b = new B(); A x = b; System.out.println(b.i + " " + x.i);
```
<details><summary>answer</summary>

`31 11`. A's i goes 10→11. B's i is 20, plus 11, so 31. `x.i` reads A's copy.
</details>

**D19** [CH07 recursion]
```java
static int r(int n) { return n <= 0 ? 0 : n % 10 + r(n / 10); }
System.out.println(r(4096) + " " + r(7));
```
<details><summary>answer</summary>

`19 7` (4+0+9+6)
</details>

**D20** [C8 returning objects]
```java
class A { int v; A(int v) { this.v = v; } A twice() { return new A(v * 2); } A self() { v++; return this; } }
A x = new A(3); A y = x.twice(); A z = x.self();
System.out.println(x.v + " " + y.v + " " + z.v + " " + (z == x) + " " + (y == x));
```
<details><summary>answer</summary>

`4 6 4 true false`. `twice()` ran while v was still 3.
</details>
