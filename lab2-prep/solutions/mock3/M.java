class M {
    static final int LIMIT = 100;
    static int created = 0;
    int side;
    String hist;

    M(int side) {
        this.side = side;
        hist = "" + side;
        created++;                     // every constructor call counts; tests read it at exact moments
    }

    class Inner {                      // needs an M object: m.new Inner(3)
        int v;
        Inner(int v) { this.v = v; }
        int total() { return side + v; }   // reads the LIVE outer field
    }

    static class Nested {              // no outer object: new M.Nested(5)
        int n;
        Nested(int n) { this.n = n; }
        int square() { return n * n; }
        static int cube(int x) { return x * x * x; }
    }

    Shape asShape() {                  // anonymous subclass of an abstract class
        return new Shape() {
            double area() { return side * side; }
            String name() { return "Square"; }
        };
    }

    void grow() {
        side++;
        hist += ">" + side;
    }

    String history() { return hist; }

    M bigger(M o) { return o.side > side ? o : this; }

    void doubleAll(int[] a) { for (int i = 0; i < a.length; i++) a[i] *= 2; }

    void doubleIt(int x) { x *= 2; }   // primitive copy -> caller unaffected

    static int sumTo(int n) { return n == 1 ? 1 : n + sumTo(n - 1); }

    public boolean equals(Object o) {
        return o instanceof M && ((M) o).side == side;
    }
}
