

public class Ticket {
    static int cnt = 0;
    int id;
    static String PREFIX = "TK";
    static int PRICE = 0;
    int discount = 0;
    // int price = Ticket.PRICE - discoun1t;
    static int issued(){return cnt;}

    Ticket() {
        cnt++; id = cnt;
    }
    String label(){
        return PREFIX + "-" + id;
    }
    int cost(){return PRICE - discount;}
    static int total(Ticket a, Ticket b){return a.cost() + b.cost();}
    static int[] make(int n){ cnt+=n;return new int[n];}
    
}
