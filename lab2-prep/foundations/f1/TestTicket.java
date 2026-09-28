// F1 - STATICS. Write class Ticket in Ticket.java.
public class TestTicket {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        tester(Ticket.issued() == 0 && Ticket.PREFIX.equals("TK"));
        Ticket a = new Ticket();
        Ticket b = new Ticket();
        tester(a.id == 1 && b.id == 2 && Ticket.issued() == 2);
        Ticket c = a;
        tester(c.id == 1 && Ticket.issued() == 2);
        tester(a.label().equals("TK-1") && b.label().equals("TK-2"));
        Ticket.PRICE = 50;
        tester(a.cost() == 50 && b.cost() == 50);
        a.PRICE = 80;
        tester(b.cost() == 80 && Ticket.PRICE == 80);
        a.discount = 30;
        tester(a.cost() == 50 && b.cost() == 80);
        tester(Ticket.total(a, b) == 130);
        new Ticket();
        tester(Ticket.issued() == 3 && a.id == 1);
        tester(Ticket.make(4).length == 4 && Ticket.issued() == 7);
    }
}
