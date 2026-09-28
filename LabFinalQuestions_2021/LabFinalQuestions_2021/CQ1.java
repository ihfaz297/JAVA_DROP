// CQ1.java
abstract class A { int i; A(int i) {this.i = i;}
    int m(int j) { return 2*i+j; } abstract int m2(int j, int k); void m4(){}} 
class B extends A { B(int i) { super(i*i-2);}
    int m2(int x, int y) { return x*y; }
}
public class CQ1 {
    public static void main(String[] args) {
        C c = new C(10, 20); B b = new B(5); System.out.println("Main C Start");
        c.m3("Java"); System.out.println("1:"+c.m2(6,6));
        System.out.println("2:"+b.m2(6,6));
        A a = b; System.out.println("3:"+a.m(15)); System.out.println("4:"+a.i);
        a = c; System.out.println("5:"+a.m(15)); System.out.println("6:"+a.i); 
        a.m4(); c.i+=15; a.m4(); a.i+=21; a.m4(); new C(100,200);
    }
}