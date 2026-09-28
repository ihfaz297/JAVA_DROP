class A implements B, B.C {
    int i;
    A(int i) { this.i = i; }
    public int m1(int x) { return x + i + B.i; }
    public String m2(String s) { return s.replace('a', 'd'); }
    public int m3(int x) { return x + i + C.i; }
    int m3(int x, int y) { return x + y + i + C.i; }
}
