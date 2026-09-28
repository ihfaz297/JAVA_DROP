class D extends B {
    String s;
    D(int i, String s) { super(i); this.s = s; }
    int m1(int x, int y) { return i + x + y - 10; }
    String m1(String t) { return "**" + s + "||" + t; }
    double m3(double... d) {
        double sum = 0;
        for (double v : d) sum += v;
        return Math.round(sum / d.length * 100) / 100.0;
    }
    class E { int k; E(int k) { this.k = k; } }
    E m2(int k) { return new E(k); }
}
