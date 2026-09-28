class B implements A, A.D {
    int j;
    B(int j) { this.j = j; }
    public int m1(int x) { return x + j + D.j; }
    public String m2(String s) { return s.replace('a', 'b'); }
    public int m3(int x) { return x + j + A.j; }
    int m3(int x, int y) { return x + y + j + D.j; }
}
