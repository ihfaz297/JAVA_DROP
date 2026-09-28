class A {
    static int i = 10;
    int j;
    static {
        System.out.println("A StaticBlock1:" + i);
    }
    {i++;}
}
public class Lab09 {
    int i = 0;
    Lab09() {
        System.out.println("Constructor");
    }
    // Non-static Block
    {System.out.println("Outside Method 1:" + i);}
    {m(); System.out.println("Outside Method 2");}

    // Static Block
    static {System.out.println("StaticBlock1");}

    

    void m() {}

    // JVM calls - Lab09.main(arg)
    public static void main(String[] args) {
        System.out.println("Main1");
        A a1; // no execution of static
        // System.out.println(A.i);
        // System.out.println("Before Object/New");
        // a1 = new A();
        Lab09 a; // no output
        new Lab09(); // output
        new Lab09(); // output
        a = new Lab09();
        // System.out.println(a);
        // a.m();
    }
    {System.out.println("Outside Method 3");}
}