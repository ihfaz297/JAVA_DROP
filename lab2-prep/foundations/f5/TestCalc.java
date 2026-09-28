// F5 - OVERLOADING, VARARGS, PASS-BY-VALUE, RETURNING OBJECTS. Box is given. Write class Calc in Calc.java.
class Box {
    int v;

    Box(int v) {
        this.v = v;
    }
}

public class TestCalc {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        tester(c.add(2, 3) == 5 && c.add(2.5, 1.5) == 4.0);
        tester(c.add("2", "3").equals("23") && c.add(1, 2, 3) == 6);
        tester(c.add() == 0 && c.add(new int[] { 4, 5, 6 }) == 15);
        tester(c.kind(5).equals("int") && c.kind(5L).equals("long") && c.kind(5.0).equals("double")
                && c.kind('A').equals("int"));
        tester(c.kind("x").equals("String") && c.kind((Object) "x").equals("Object"));
        int[] arr = { 1, 2, 3 };
        int n = 7;
        c.reset(arr);
        c.reset(n);
        tester(arr[0] == 0 && arr[2] == 0 && n == 7);
        Box b = new Box(5);
        c.bump(b);
        tester(b.v == 6);
        Box x = new Box(1), y = new Box(2);
        c.swapRefs(x, y);
        boolean same = x.v == 1 && y.v == 2;
        c.swapVals(x, y);
        tester(same && x.v == 2 && y.v == 1);
        tester(c.join("-", "a", "b", "c").equals("a-b-c") && c.join("-").equals(""));
        tester(c.max(3, 9, 2).v == 9 && c.max(4).v == 4);
    }
}
