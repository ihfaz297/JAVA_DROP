class N implements Shape2, Shape2.Scalable {
    static int count = 0;
    int w, h;

    N(int w, int h) {
        this.w = w;
        this.h = h;
        count++;
    }

    public int area() { return w * h; }            // interface methods are public -> MUST say public

    public String describe() {
        return "N:" + w + "x" + h + " " + Shape2.super.describe();   // call the default you override
    }

    public int scale(int k) { return area() * k * FACTOR; }

    int area(int k) { return area() * k; }         // overload, not override

    N flipped() { return new N(h, w); }

    static N unit() { return new N(1, 1); }

    public String toString() { return "N(" + w + "," + h + ")"; }
}
