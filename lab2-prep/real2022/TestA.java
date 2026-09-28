interface B {
    int i = 10;

    int m1(int i);

    default String m2(String s) {
        return s.replace('a', 'b');
    }

    interface C {
        int i = 20;

        int m3(int i);
    }
}

public class TestA {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        A a = new A(5);
        tester((a.i + B.i + B.C.i) == 35);
        B b = a;
        tester(b.m1(15) == 30 && b.m1(5) == 20);
        a.i += 10;
        tester(b.m1(15) == 40 && b.m1(5) == 30);
        tester(b.m2("abaabd").equals("dbddbd"));
        tester(b.m2("baddabaa").equals("bddddbdd"));
        B.C c = (B.C) b;
        tester(c.m3(5) == 40 && c.m3(15) == 50);
        tester(a.m3(5, 10) == 50 && a.m3(15, 10) == 60);
        a.i += 10;
        tester(c.m3(15) == 60);
        tester(a.m3(15, 10) == 70);
        tester(new A(B.i).m3(10, 10) == 50);
    }
}
