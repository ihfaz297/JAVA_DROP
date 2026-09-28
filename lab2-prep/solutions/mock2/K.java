class K extends Base {
    static int total;
    int id = -1;                       // runs AFTER Base() finishes -> show() inside Base() sees 0

    static {
        System.out.println("K static");
    }

    {
        total++;
        System.out.println("K init " + total);
    }

    K() {
        this(0);                       // this() chains: init blocks run only once
        System.out.println("K()");
    }

    K(int id) {
        super();
        this.id = id;
        System.out.println("K(" + id + ")");
    }

    void show() {
        System.out.println("K.show id=" + id);
    }

    int fact(int n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }

    static int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    public String toString() {
        return "K#" + id;
    }
}
