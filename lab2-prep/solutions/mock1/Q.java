class Q extends P {
    int y;

    Q(int x, int y) {
        super(x);
        this.y = y;
    }

    Q(Q other) {                       // copy constructor -> still goes through P(), so count++
        this(other.x, other.y);
    }

    int calc(int a) {
        return x * a + y;              // x here is P.x (R's hidden x is invisible from Q)
    }

    int calc(int a, int b) {           // overload
        return calc(a) + calc(b);      // dynamic dispatch: inside R this calls R.calc
    }

    int sum(int... v) {                // varargs; sum() with zero args is legal
        int s = x;
        for (int e : v) s += e;
        return s;
    }

    public String toString() {
        return "Q[" + x + "," + y + "]";
    }

    class Node {                       // inner (non-static) class: has Q.this
        int val;
        Node(int val) { this.val = val; }
        Q owner() { return Q.this; }
    }

    Node node(int v) {
        return new Node(v);
    }

    static Q max(Q a, Q b) {           // returning objects; ties -> first one
        return b.calc(1) > a.calc(1) ? b : a;
    }
}
