// F3 - NESTED CLASSES. Greeter is given. Write class House in House.java.
abstract class Greeter {
    abstract String greet(String who);
}

public class TestHouse {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        House h = new House("Blue");
        House.Room r = h.new Room("kitchen");
        tester(r.describe().equals("kitchen of Blue"));
        House.Room r2 = h.addRoom("bath");
        tester(r2.describe().equals("bath of Blue") && h.roomCount == 2);
        h.color = "Red";
        tester(r.describe().equals("kitchen of Red"));
        tester(r.home() == h);
        House.Plan p = new House.Plan(3);
        tester(p.floors == 3 && p.info().equals("plan:3:Standard"));
        tester(House.Plan.cheapest().floors == 1);
        Greeter g = h.doorbell();//////
        tester(g.greet("Ana").equals("Welcome to Red, Ana"));
        h.color = "Green";
        tester(g.greet("Bo").equals("Welcome to Green, Bo"));
        House h2 = new House("White");
        House.Room r3 = h2.new Room("attic");
        tester(r3.describe().equals("attic of White") && r.home() != r3.home());
        tester(h.roomCount == 2 && h2.roomCount == 1 && House.built == 2);
    }
}
