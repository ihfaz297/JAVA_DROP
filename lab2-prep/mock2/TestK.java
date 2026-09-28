class Base {
    static {
        System.out.println("Base static");
    }

    {
        System.out.println("Base init");
    }

    Base() {
        System.out.println("Base()");
        show();
    }

    void show() {
        System.out.println("Base.show");
    }
}

public class TestK {
    public static void main(String[] args) {
        System.out.println("Main Start");
        K k = new K(7);
        k.show();
        System.out.println(K.total);
        new K();
        System.out.println(K.total + " " + k.id);
        Base b = k;
        b.show();
        System.out.println(k.fact(5) + " " + K.fib(10));
        System.out.println(k);
    }
}
