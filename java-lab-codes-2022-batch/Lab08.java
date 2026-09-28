class B {} class C {}
class A {
    A() {}
    A(int i) {}
    A(float i) {}
    void m() { System.out.println("m()");}
    //void m() {}// error: method m() is already defined in class A
    //int m() { return 1;} //error: method m() is already defined in class A
    void m(int i) {System.out.println("m(int)");}
    void m(int i, int j) {System.out.println("m(int,int)");}
    void m(long i) {System.out.println("m(long)");}
    void m(float i) {System.out.println("m(float)");}
    void m(double d) {System.out.println("m(double)");}
    void m(long i,int j) {System.out.println("m(long,int)");}
    void m(int i,long j) {System.out.println("m(int,long)");}
    void m(B b) {System.out.println("m(B)");}
    void m(C c) {System.out.println("m(C)");}
    void m(B b, C c) {System.out.println("m(B,C)");}
}
public class Lab08 {
    public static void main(String[] args) {
        A a = new A(); a.m(); a.m(0); a.m(2.2f);
        a.m(1L,1); a.m(1,1L); a.m(new B()); a.m(new C());
        a.m(new B(),new C());
        // a.m(1,1);// error: reference to m is ambiguous
        // a.m(null); // error: reference to m is ambiguous
    }
}