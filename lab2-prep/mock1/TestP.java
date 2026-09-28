abstract class P {
    int x;
    static int count = 0;

    P(int x) {
        this.x = x;
        count++;
    }

    abstract int calc(int a);

    int twice(int a) {
        return 2 * calc(a);
    }
}

class R extends Q {
    int x = 100;

    R(int x) {
        super(x, x * 2);
    }

    int calc(int a) {
        return super.calc(a) + x;
    }

    int parentX() {
        return super.x;
    }
}

public class TestP {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        Q q = new Q(3, 4);
        tester(q.x == 3 && q.y == 4 && P.count == 1);
        tester(q.calc(5) == 19 && q.twice(5) == 38);
        tester(q.calc(2, 3) == 23 && q.calc(0, 0) == 8);
        tester(q.sum() == 3 && q.sum(1, 2, 3) == 9);
        Q q2 = new Q(q);
        tester(q2.x == 3 && q2.y == 4 && q2 != q && P.count == 2);
        tester(q.toString().equals("Q[3,4]") && ("" + q2).equals("Q[3,4]"));
        Q.Node n = q.node(7);
        tester(n.val == 7 && n.owner() == q);
        R r = new R(5);
        P p = r;
        tester(p.x == 5 && r.x == 100 && r.parentX() == 5 && P.count == 3);
        tester(p.calc(2) == 120 && p.twice(1) == 230);
        tester(Q.max(q, r) == r && Q.max(q, q2) == q);
    }
}
