class Ticket {
    static final String PREFIX = "TK";   // one copy, never changes
    static int PRICE = 0;                // one copy, SHARED: a.PRICE = 80 changes it for everyone
    static int count = 0;                // one copy: counts all tickets ever made

    int id;                              // every ticket has its own
    int discount = 0;                    // every ticket has its own

    Ticket() {
        count++;
        id = count;
    }

    static int issued() { return count; }                 // static: no object needed, no 'this'

    String label() { return PREFIX + "-" + id; }          // instance method can read static stuff freely

    int cost() { return PRICE - discount; }

    static int total(Ticket x, Ticket y) {                // a static method must be HANDED objects
        return x.cost() + y.cost();                       // to reach instance data
    }

    static Ticket[] make(int n) {
        Ticket[] arr = new Ticket[n];
        for (int i = 0; i < n; i++) arr[i] = new Ticket();
        return arr;
    }
}
