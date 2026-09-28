abstract class Shape {
    abstract double area();

    String name() {
        return "Shape";
    }
}

public class TestM {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        M m = new M(4);
        tester(m.side == 4 && M.created == 1 && M.LIMIT == 100);
        M.Inner in = m.new Inner(3);
        tester(in.total() == 7);
        M.Nested ne = new M.Nested(5);
        tester(ne.square() == 25 && M.Nested.cube(2) == 8);
        Shape s = m.asShape();
        tester(s.area() == 16.0 && s.name().equals("Square"));
        m.grow();
        m.grow();
        tester(m.side == 6 && m.history().equals("4>5>6"));
        M m2 = m.bigger(new M(10));
        tester(m2.side == 10 && M.created == 2 && m.bigger(new M(1)) == m);
        int[] arr = { 1, 2, 3 };
        int v = 5;
        m.doubleAll(arr);
        m.doubleIt(v);
        tester(arr[0] == 2 && arr[2] == 6 && v == 5);
        tester(M.sumTo(100) == 5050 && M.sumTo(1) == 1);
        tester(new M(3).equals(new M(3)) && !new M(3).equals(new M(4)));
        tester(M.created == 7 && in.total() == 9);
    }
}
