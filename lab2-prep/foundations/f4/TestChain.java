// F4 - CONSTRUCTORS, super(), this(), INIT ORDER. Log, Vehicle, SportsCar are given. Write class Car in Car.java.
class Log {
    static String s = "";

    static void add(String x) {
        s += x + ";";
    }
}

class Vehicle {
    int wheels;

    static {
        Log.add("Vs");
    }

    {
        Log.add("Vi");
    }

    Vehicle(int wheels) {
        this.wheels = wheels;
        Log.add("V" + wheels);
    }
}

class SportsCar extends Car {
    SportsCar() {
        super("Zoom", 300);
        Log.add("SC");
    }
}

public class TestChain {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        tester(Log.s.equals(""));
        Car c = new Car("Axio", 120);
        tester(Log.s.equals("Vs;Cs;Vi;V4;Ci;C2;"));
        tester(c.wheels == 4 && c.model.equals("Axio") && c.speed == 120);
        Log.s = "";
        Car d = new Car("Allion");
        tester(Log.s.equals("Vi;V4;Ci;C2;C1;") && d.speed == 100);
        Log.s = "";
        Car e = new Car();
        tester(Log.s.equals("Vi;V4;Ci;C2;C1;C0;") && e.model.equals("Generic"));
        Log.s = "";
        SportsCar s = new SportsCar();
        tester(Log.s.equals("Vi;V4;Ci;C2;SC;") && s.speed == 300);
        tester(Car.made == 4);
        tester(c.faster(d) == c && d.faster(c) == c);
        tester(e.upgrade(50).speed == 150 && e.speed == 100 && Car.made == 5);
        Log.s = "";
        e.upgrade(1);
        tester(Log.s.equals("Vi;V4;Ci;C2;") && Car.made == 6);
    }
}
