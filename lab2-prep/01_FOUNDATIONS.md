# Foundations: rebuilding the basics from zero

This is for you if Java is rusty and polymorphism, nested classes and statics never quite sat right.
**Every section follows the same shape:** a mental picture, the rules, a tiny demo to **type and run** (typing, not reading), then an exercise.

The exercises are in `foundations/f1` … `f6`. Same format as his exam: a locked `TestX.java`, you write one class, and you aim for 10/10.
Easier than the mocks, **on purpose**. Solutions: `solutions/foundations/`, with comments on every line that matters.

Order: **§0 → §1 → §2 (F1) → §3 (F4) → §4 (F5) → §5 (F2) → §6 (F3) → §7 (F6)**.
You'll see F-numbers out of order. They follow the reading order, which goes from easy to hard.

---

## §0. Syntax refresher (shake off the rust, 15 min)

Type this whole thing into `Refresh.java`, run it, and read the output:
```java
public class Refresh {                                   // file name MUST equal public class name
    int x;                                               // field (instance variable)
    Refresh(int x) { this.x = x; }                       // constructor: same name as class, no return type

    int twice() { return x * 2; }                        // method: return type, name, params

    public static void main(String[] args) {
        Refresh r = new Refresh(21);
        System.out.println(r.twice());                   // 42

        int[] a = {3, 1, 2};                             // array
        int[] b = new int[5];                            // 5 zeros
        System.out.println(a.length + " " + b[4]);       // length is a FIELD for arrays (no ())

        String s = "hello";
        System.out.println(s.length() + " " + s.charAt(1) + " " + s.toUpperCase()
                + " " + s.substring(1, 3) + " " + s.replace('l', 'L') + " " + s.indexOf('l'));
                                                          // length() is a METHOD for Strings

        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
        for (int v : a) System.out.print(v + " ");       // for-each
        System.out.println();

        System.out.printf("%d | %.2f | %s | %02d%n", 7, 3.14159, "str", 5);
        System.out.println(10 / 4 + " " + 10 / 4.0 + " " + 10 % 4 + " " + (double) 10 / 4);
        System.out.println(Math.max(3, 8) + " " + Math.abs(-5) + " " + Math.round(2.5) + " " + Math.pow(2, 10));
        String t = (5 > 3) ? "yes" : "no";                // ternary: shows up constantly in answers
        System.out.println(t + " " + ("a" + 1 + 2) + " " + (1 + 2 + "a"));   // a12 vs 3a
    }
}
```
Compile + run: `javac Refresh.java` then `java Refresh`.
Several classes in one file? Fine. Only **one** can be `public`, and it names the file.

---

## §1. Objects and references (everything else is built on this)

**Picture:** `new Dog()` builds a dog **somewhere in memory**. The variable `d` is a **remote control** pointing at it.
```java
Dog a = new Dog();   // 1 dog, 1 remote
Dog b = a;           // still 1 dog, now 2 remotes pointing at it
b.name = "Rex";      // a.name is "Rex" too: same dog
Dog c = new Dog();   // a second dog
a == b               // true : same dog
a == c               // false: different dogs, even if identical inside
```
Rules:
- `new` = one new object. **No `new`, no new object.** That's how you count objects in his tests.
- `==` on objects asks "same object?". `.equals()` asks "same content?", if the class defines it.
- Passing an object to a method passes **a copy of the remote**, so the method can change the dog, but it can't change which dog *your* remote points at.

---

## §2. `static`: "belongs to the class, not to any object"  → exercise **F1**

**Picture:** a class is an **apartment building**. Every object is an **apartment**.
- **Instance** field = each apartment's own fridge. 10 apartments, 10 fridges.
- **Static** field = the building's single notice board. 10 apartments, **1** board.
- A **static method** is the building manager. The manager isn't inside any apartment, so they can't say "my fridge". They have **no `this`**.

```java
class Flat {
    static int count = 0;   // ONE copy, shared
    int number;             // one per object
    Flat() { count++; number = count; }
    static int howMany() { return count; }          // ✔ static can use static
    // static int bad() { return number; }          // ✘ which flat's number? there's no 'this'
    String show() { return number + "/" + count; }  // ✔ instance can use BOTH
}
// Flat.howMany()    ✔ call static through the class name (preferred)
// f.howMany()       ✔ also compiles: Java quietly uses the class. Same board.
// f.count = 99      changes Flat.count for EVERYONE (one board!)
```
Type it, make 3 flats, print `show()` for each, then set `f1.count = 99` and print `f3.show()`.

Rules to say out loud:
1. Static = one copy per class. Instance = one copy per object.
2. Static methods can't touch instance fields or call instance methods **directly**. They need an object handed to them (`static int total(Flat a, Flat b)`).
3. Instance methods can touch everything.
4. `static final` = a shared constant (`static final int MAX = 10`).
5. **Static blocks** `static { ... }` run **once**, the first time the class is used. **Instance blocks** `{ ... }` run on **every** `new`.

**Now do F1** (`foundations/f1/TestTicket.java` → write `Ticket.java`). Stuck? Read the test line and ask "one copy or one per ticket?"

---

## §3. Constructors, `this(...)`, `super(...)`, init order  → exercise **F4**

**Picture:** building a `Car` is building a `Vehicle` first, then adding the car-specific parts on top.
The parent part is **always** finished before the child part starts.

```java
class Vehicle { int wheels; Vehicle(int w) { wheels = w; } }       // note: NO Vehicle() exists
class Car extends Vehicle {
    String model;
    Car(String m) { super(4); model = m; }   // super(...) = "build my parent part with THIS"
    Car()         { this("Generic"); }       // this(...)  = "use my other constructor"
}
```
Rules:
1. Every constructor's first line is `super(...)` or `this(...)`. If you write neither, Java silently inserts `super()`.
   So if the parent has **no** no-arg constructor, you **must** write `super(something)`. That's the most common compile error in his exam.
2. Only one of them, and only as the first line.
3. `this(...)` chains eventually hit one constructor that calls `super(...)`. The parent gets built **once**.
4. **Full order for `new Child()`:**
   ```
   (first time only) Parent static blocks → Child static blocks
   Parent field inits + instance blocks → Parent constructor body
   Child  field inits + instance blocks → Child  constructor body
   ```

Type this and **predict before running**:
```java
class P { static { System.out.println("P static"); } { System.out.println("P block"); }
          P() { System.out.println("P()"); } }
class C extends P { static { System.out.println("C static"); } { System.out.println("C block"); }
          C() { this(1); System.out.println("C()"); }
          C(int x) { System.out.println("C(int)"); } }
public class Order { public static void main(String[] a) { new C(); System.out.println("--"); new C(); } }
```
<details><summary>output</summary>

```
P static
C static
P block
P()
C block
C(int)
C()
--
P block
P()
C block
C(int)
C()
```
</details>

**Now do F4** (`foundations/f4/TestChain.java` → write `Car.java`). The test checks a log string, so it literally checks the order.

---

## §4. Overloading, varargs, pass-by-value  → exercise **F5**

**Overloading** = same method name, **different parameter list**. Java picks one **at compile time** by looking at the argument types.
```java
int    add(int a, int b)       { ... }
double add(double a, double b) { ... }
int    add(int... v)           { ... }   // varargs: v is just an int[] inside
// int add(int x, int y) {...}   ✘ same params again
// long add(int a, int b) {...}  ✘ return type alone doesn't count
```
How Java picks: **exact match → widening (int→long→double, char→int) → boxing (int→Integer) → varargs.** Varargs comes last.

Varargs rules: only one per method, and it must be **last**: `join(String sep, String... parts)`.
It accepts zero args, many args, or an actual array.

**Pass-by-value:** Java **always** copies what you pass.
- Primitive: copies the number, so changing it inside does nothing outside.
- Object/array: copies the **remote**, so `b.v++` or `arr[0] = 0` **is** visible outside. But `b = new Box()` inside only moves the local remote.

**Now do F5** (`foundations/f5/TestCalc.java` → write `Calc.java`). Test 4 has `kind('A')`. Think about widening.

---

## §5. Inheritance & polymorphism (THE big one)  → exercise **F2**

**Picture:** the variable's type is the **label on the remote**. The object is **the actual TV**.
```java
Animal a = new Dog("Bolt");
//  ^ label (declared type)   ^ the real thing (actual type)
```

### The two-question rule (this settles 95% of his questions)
For any `a.something`:

**Q1, compile time: "Does the LABEL have it?"** The compiler only knows the label, `Animal`.
- `a.sound()` → Animal has `sound()` → ✔ compiles
- `a.fetch()` → Animal has no `fetch()` → ✘ **compile error**, even though the real object is a Dog.
  Fix: `((Dog) a).fetch()`. A cast changes the **label**, never the object.

**Q2, run time: "WHICH version runs?"**
| Thing | Decided by | Example with `Animal a = new Dog()` |
|---|---|---|
| **instance method** | the real **object** | `a.sound()` → Dog's `"woof"` |
| **field** | the **label** | `a.name` → Animal's `"animal"` if Dog re-declared `name` |
| **static method** | the **label** | `a.kingdom()` → Animal's |

That's it. **Methods follow the object. Fields and statics follow the label.**

More rules:
- **Overriding** = same name + **same params** in the child. That's what polymorphism uses.
- **Overloading** = different params. It's just a different method, not polymorphism.
- Inside a parent method, calling `sound()` still runs the **child's** version (Animal's `intro()` calls `sound()` and gets "woof").
- `super.method()` = "run the parent's version". `super.field` = "the parent's copy of the field".
- A bad cast compiles but crashes at runtime (`ClassCastException`). `x instanceof Dog` checks first.
- Upcast (Dog → Animal) is automatic. Downcast (Animal → Dog) needs `(Dog)`.

Type this, **predict every line**, then run:
```java
class Animal { String name = "animal"; String sound() { return "..."; }
               String intro() { return name + " says " + sound(); } static String k() { return "A"; } }
class Dog extends Animal { String name = "dog"; String sound() { return "woof"; } static String k() { return "D"; } }
public class Poly { public static void main(String[] x) {
    Animal a = new Dog(); Dog d = (Dog) a;
    System.out.println(a.sound() + " " + a.name + " " + d.name + " " + a.intro() + " " + a.k() + " " + d.k());
}}
```
<details><summary>output</summary>

`woof animal dog animal says woof A D`.
`intro()` lives in Animal, so the `name` inside it is Animal's name. `sound()` inside it is a method call, so it follows the object and gives woof.
</details>

**Now do F2** (`foundations/f2/TestZoo.java` → write `Dog.java`). Before each test, answer Q1 and Q2 out loud.

---

## §6. Nested classes: four kinds, one picture each  → exercise **F3**

```java
class House {
    String color;
    class Room { }                 // 1. INNER (non-static)
    static class Plan { }          // 2. STATIC NESTED
    void m() {
        class Tmp { }              // 3. LOCAL (rare in his tests)
        Greeter g = new Greeter() { ... };   // 4. ANONYMOUS
    }
}
```

**1. Inner class = a Room.** A room can't exist without a house, and it **knows its house**.
- Create: `House.Room r = h.new Room();` (from outside). Inside House's own methods, just `new Room()`.
- It reads the house's fields directly (`color`), **live**: repaint the house and every room sees the new color.
- To get the house object itself: `House.this`.
- Two houses, and each house's rooms see **their own** house.

**2. Static nested class = a blueprint filed in the house's folder.** It's just a normal class with a long name.
- Create: `new House.Plan(3)`. **No house needed.**
- It **can't** see `color` (which house would it be?). It can see House's **static** fields.
- Think of it as "static" in the same sense as §2: it belongs to the class, not to an object.

**3. Local class**: a class declared inside a method, and only usable there.

**4. Anonymous class = a one-off subclass with no name, made and used on the spot.**
```java
Greeter g = new Greeter() {                       // "a Greeter subclass, just this once"
    String greet(String who) { return "Hi " + who + " from " + color; }
};
```
- Typically used to implement an abstract class or interface **right there**.
- It can read the outer object's fields (live) and **effectively-final** local variables.
- It must implement every abstract method.

| | Needs outer object? | Sees outer instance fields? | How to create |
|---|---|---|---|
| inner | **yes** | **yes** (live) | `outer.new Inner()` |
| static nested | no | **no** (only static ones) | `new Outer.Nested()` |
| anonymous | if made in an instance method, yes | yes | `new Parent() { ... }` |

**Now do F3** (`foundations/f3/TestHouse.java` → write `House.java`).

---

## §7. Abstract, final, interfaces  → exercise **F6**

**Abstract class = an unfinished blueprint.** "Every Shape has an area, but I can't say how."
```java
abstract class Shape {
    Shape(String k) { ... }        // ✔ abstract classes CAN have constructors, fields, normal methods
    abstract double area();        // no body; children MUST write it
    String info() { return "" + area(); }   // normal method that CALLS the abstract one (polymorphism!)
}
// new Shape("x")   ✘ can't instantiate an abstract class
// A non-abstract child MUST implement every abstract method, or it won't compile.
```

**final** means "locked":
- `final int x` → assign once. `final` method → can't override. `final class` → can't extend.

**Interface = a contract of abilities.** "Anything Resizable has `resize(int)`."
```java
interface Resizable {
    int MAX = 10;                  // automatically public static final: a constant
    void resize(int f);            // automatically public abstract
    default boolean big() { return false; }   // has a body; implementers MAY override
    static int twice(int x) { return 2 * x; } // call as Resizable.twice(3) only
}
class Circle extends Shape implements Resizable {   // extend 1 class, implement many interfaces
    public void resize(int f) { ... }              // ← MUST be public. Forgetting = compile error.
}
```
- A `Resizable z = circle;` label can only call Resizable things (§5 Q1 again).
- To call the interface's default from your override: `Resizable.super.big()`.
- Interfaces can be nested inside interfaces (`B.C`), and a class can implement both (`implements B, B.C`). That was 2022 Sets A/B.

**Now do F6** (`foundations/f6/TestShape.java` → write `Circle.java`).

---

## You're done with foundations when…
- F1–F6 all give 10/10 **without** opening the solutions (peeking at one line on the first pass is fine; redo it clean later).
- You can say the two-question rule (§5) and the init order (§3) without looking.

Then go to `02_INTEL.md` → `03_TUTORIAL.md`. The real exam material is the same ideas with his tricks layered on.
