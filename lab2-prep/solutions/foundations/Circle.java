class Circle extends Shape implements Resizable {   // extends ONE class, implements any number of interfaces
    int r;

    Circle(int r) {
        super("circle");                 // Shape(String) is the only constructor -> must call it
        this.r = r;
    }

    double area() { return 3 * r * r; }  // MUST implement: Shape.area() is abstract and Circle is not

    public void resize(int f) {          // interface method -> MUST be public
        r = Math.min(r * f, MAX);        // MAX is inherited from Resizable
    }

    public boolean big() { return r > 5; }   // overriding a default method (still public)

    // can NOT write tag() here: it's final in Shape

    static double totalArea(Shape[] arr) {    // each element runs its OWN area() (Ring's for the ring)
        double t = 0;
        for (Shape s : arr) t += s.area();
        return t;
    }

    public boolean equals(Object o) {
        return o != null && o.getClass() == Circle.class && ((Circle) o).r == r;
    }
}
