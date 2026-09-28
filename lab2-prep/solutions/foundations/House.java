class House {
    static int built = 0;
    static String STYLE = "Standard";
    String color;
    int roomCount = 0;

    House(String color) {
        this.color = color;
        built++;
    }

    class Room {                         // INNER: every Room is glued to ONE House
        String rname;

        Room(String rname) {
            this.rname = rname;
            roomCount++;                 // = House.this.roomCount++ -> MY house's counter
        }

        String describe() { return rname + " of " + color; }   // reads MY house's color, live

        House home() { return House.this; }
    }

    Room addRoom(String n) { return new Room(n); }    // inside House, the outer object is 'this'

    static class Plan {                  // STATIC NESTED: a normal class filed under House. No house attached.
        int floors;

        Plan(int floors) { this.floors = floors; }

        String info() { return "plan:" + floors + ":" + STYLE; }   // static fields OK; color would NOT compile

        static Plan cheapest() { return new Plan(1); }
    }

    Greeter doorbell() {                 // ANONYMOUS: a one-off subclass of Greeter made on the spot
        return new Greeter() {
            String greet(String who) { return "Welcome to " + color + ", " + who; }
        };
    }
}
