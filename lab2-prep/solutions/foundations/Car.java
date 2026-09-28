class Car extends Vehicle {
    static int made = 0;
    String model;
    int speed;

    static {                         // runs ONCE, the first time Car is used (after Vehicle's static)
        Log.add("Cs");
    }

    {                                // runs on EVERY new Car, right after Vehicle(...) finishes
        Log.add("Ci");
        made++;
    }

    Car(String model, int speed) {   // the "real" constructor: the only one that calls super
        super(4);
        this.model = model;
        this.speed = speed;
        Log.add("C2");
    }

    Car(String model) {              // delegates with this(...). No super here, this() handles it
        this(model, 100);
        Log.add("C1");
    }

    Car() {
        this("Generic");
        Log.add("C0");
    }

    Car faster(Car o) { return o.speed > speed ? o : this; }

    Car upgrade(int k) { return new Car(model, speed + k); }   // NEW object; this one is untouched
}
