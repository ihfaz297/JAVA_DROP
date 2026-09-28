class Calc {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }   // overload: different param TYPES
    String add(String a, String b) { return a + b; }

    int add(int... v) {                  // varargs: add(), add(1,2,3), add(new int[]{...}) all land here
        int s = 0;                       // (add(2,3) still picks add(int,int): exact match beats varargs)
        for (int e : v) s += e;
        return s;
    }

    String kind(int x) { return "int"; }        // kind('A'): char WIDENS to int -> "int"
    String kind(long x) { return "long"; }
    String kind(double x) { return "double"; }
    String kind(String x) { return "String"; }
    String kind(Object x) { return "Object"; }  // picked by the DECLARED type (Object), not the real one

    void reset(int[] a) { for (int i = 0; i < a.length; i++) a[i] = 0; }  // same array -> caller sees it
    void reset(int x) { x = 0; }                                          // a copy -> caller doesn't

    void bump(Box b) { b.v++; }          // changing the object through the reference: visible

    void swapRefs(Box a, Box b) {        // swapping LOCAL copies of references: invisible outside
        Box t = a; a = b; b = t;
    }

    void swapVals(Box a, Box b) {        // swapping the contents of the objects: visible
        int t = a.v; a.v = b.v; b.v = t;
    }

    String join(String sep, String... parts) {   // varargs must be the LAST parameter
        String r = "";
        for (int i = 0; i < parts.length; i++) r += (i > 0 ? sep : "") + parts[i];
        return r;
    }

    Box max(int... v) {
        int m = v[0];
        for (int e : v) if (e > m) m = e;
        return new Box(m);
    }
}
