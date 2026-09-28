class Dog extends Animal {
    String name = "dog";        // HIDES Animal.name -> which one you see depends on the variable's type
    String dogName;

    Dog(String dogName) {
        super(4);               // Animal has no Animal(), so this is compulsory
        this.dogName = dogName;
    }

    String sound() { return "woof"; }                 // OVERRIDE: runs even through an Animal variable

    String fetch() { return dogName + " fetches"; }   // new method: Animal variables can't see it

    String intro(boolean full) {                      // OVERLOAD of intro() (different params)
        return name + " " + dogName + " says " + sound();
    }

    static String kingdom() { return "Canis"; }       // static: HIDES, doesn't override

    static String loudest(Animal[] arr) {             // one loop, each element runs its OWN sound()
        String r = "";
        for (int i = 0; i < arr.length; i++) r += (i > 0 ? "|" : "") + arr[i].sound();
        return r;
    }
}
