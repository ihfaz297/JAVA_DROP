interface Shape2 {
    int SIDES = 0;

    int area();

    default String describe() {
        return "Area=" + area();
    }

    static int twice(int x) {
        return 2 * x;
    }

    interface Scalable {
        int FACTOR = 3;

        int scale(int k);
    }
}

public class TestN {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        N n = new N(2, 5);
        tester(n.w + n.h + Shape2.SIDES + Shape2.Scalable.FACTOR == 10);
        Shape2 s = n;
        tester(s.area() == 10 && Shape2.twice(s.area()) == 20);
        tester(s.describe().equals("N:2x5 Area=10"));
        Shape2.Scalable sc = (Shape2.Scalable) s;
        tester(sc.scale(2) == 60);
        n.w = 4;
        tester(s.area() == 20 && sc.scale(1) == 60);
        Shape2 t = n.flipped();
        tester(t instanceof N && t.describe().equals("N:5x4 Area=20"));
        tester(n.area(3) == 60 && n.area() == 20);
        tester(N.unit().area() == 1 && N.unit() != N.unit());
        tester(n.toString().equals("N(4,5)"));
        tester(N.count == 5);
    }
}
