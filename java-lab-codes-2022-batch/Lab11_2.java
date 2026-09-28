interface I { 
    // int i; //error: = expected
    int i = 10; //int k = II.j;
    // void m(){} //error: interface abstract methods cannot have body
    abstract void m();
    // default void m2();//error: missing method body, or declare abstract
    default void m2() {
        System.out.println("I.m2()");
        m4(); m3();
    }
    // default static void m6() {} //error: illegal combination of modifiers: static and default
    static void m3() {}
    private void m4() {}
    interface II { int i=60;
        // int j = i+50; 
        int j = I.i+50; 
        default void m2() { //m2();
            System.out.println("II.m2()");
        }
        static void m5() {m3();}
        interface III {}
    }
}
interface J extends I  { //int i = 20; //void m();
    default void m2() {
        // I.m3();
        // m3(); // Error
        // m4(); // Error
        System.out.println("J.m2()");
    }
}
// abstract class A implements I {
class A implements I, J, I.II, I.II.III {
    public void m2() {}
    // int i = 30;
    // void m() {} // Error 
    public void m() {
        System.out.println("A.m()");
    }
}
public class Lab11_2 {
    public static void main(String[] args) {
        A a = new A();
        // System.out.println(a.i);
        // System.out.println(I.i);
        // System.out.println(A.i);
        // a.i++; //error: cannot assign a value to static final variable
        // a.m();
        I i = a; System.out.println(i.i);
        J j = a; System.out.println(j.i);
        i.m(); j.m();
        // System.out.println(a.j);
        a.m2();
        // a.m4(); // Error
        // a.m3();// Error
        // System.out.println(I.i);
        // System.out.println(I.II.i);
    }
}