// enum A { }
// enum A { AA, BB, CC, DD}
enum A { AA, BB(20), CC, DD(50);
    int n;
    A() {n = -10;}
    A(int i) { n = i;}
    int getN() { return n;}
}
enum B { AA, BB, CC, DD}
public class Lab13_3 {
    public static void main(String[] args) {
        // Integer io = 12;
        // int ip = io;
        // Boolean bo = true;
        // Boolean bo = Boolean.valueOf("true");
        // System.out.println(bo);
        // A a = new A(); //error: enum classes may not be instantiated
        // A a = A.
        // A a = A.AA; A b = A.BB;
        // System.out.println(a);
        // System.out.println(a.ordinal());
        // System.out.println(b);
        // System.out.println(b.ordinal());
        // System.out.println(A.valueOf("CC").ordinal());
        // for (A aa:A.values())
        // System.out.println(aa+" " +aa.ordinal()+" "+aa.getN());
        A a = A.AA; B b = B.AA;
        // System.out.println(a==b); //error: incomparable types: A and B
        System.out.println(a.equals(A.AA));
        System.out.println(a.equals(A.BB));
        System.out.println(a.equals(A.valueOf("AA")));
        System.out.println(a.equals(b));
        System.out.println(a.equals(B.valueOf("AA")));

    }
    
}