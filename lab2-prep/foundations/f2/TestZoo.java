// F2 - POLYMORPHISM. Animal and Puppy are given. Write class Dog in Dog.java.
class Animal {
    String name = "animal";
    int legs;

    Animal(int legs) {
        this.legs = legs;
    }

    String sound() {
        return "...";
    }

    String intro() {
        return name + " says " + sound();
    }

    static String kingdom() {
        return "Animalia";
    }
}

class Puppy extends Dog {
    Puppy() {
        super("Rex");
    }

    String sound() {
        return "yip";
    }
}

public class TestZoo {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        Dog d = new Dog("Bolt");
        tester(d.legs == 4 && d.dogName.equals("Bolt"));
        tester(d.sound().equals("woof") && d.fetch().equals("Bolt fetches"));
        Animal a = d;
        tester(a.sound().equals("woof"));
        tester(a.name.equals("animal") && d.name.equals("dog"));
        tester(a.intro().equals("animal says woof"));
        tester(d.intro(true).equals("dog Bolt says woof"));
        Animal p = new Puppy();
        tester(p.sound().equals("yip") && p.intro().equals("animal says yip"));
        tester(((Dog) p).fetch().equals("Rex fetches") && p instanceof Dog);
        tester(Animal.kingdom().equals("Animalia") && Dog.kingdom().equals("Canis"));
        tester(Dog.loudest(new Animal[] { a, p, new Animal(2) }).equals("woof|yip|..."));
    }
}
