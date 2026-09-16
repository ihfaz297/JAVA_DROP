/**
 * @LabID: 07
 * @Date: 2026-09-09
 * @RegNo: 2022331008
 * @Section: B
 */

package p1;

import p2.T;
public class L07_2022331008 extends p2.T {
    public static void main(String[] args) {
        // R r=new R();
        // r.m(); r.m2();
        // // T t;cannot find symbol
        // p2.T t=new p2.T();
        // // t.m();
        // // t.m2();
        // m3();
        // new L07_2024331008();
        // p1.p3.V v=new p1.p3.V();
        // // v.m();
        I i;
        // new I();I is abstract; cannot be instantiated
        IO.println(I.n);
        IO.println(I.m);
    }
    // L07_2024331008(){m();}
    
}
interface I{
        // {}initializers not allowed in interfaces
        // static{}initializers not allowed in interfaces
        // int n;expected int n;
        int n=11;
        public final static int m=22;
        // void g(){}interface abstract methods cannot have body
        void g();
        public abstract void h();
        interface J{
            interface K{}
}
        }
        
// class Q implements I{}Q is not abstract and does not override abstract method h() in I
abstract class Q implements I{}
class X implements I{
    // void g(){}//error
    public void g(){
        IO.println("X.g()");
    }
    public void h(){

        IO.println("X.h()");
    }
    public static void main(String[] args){
        I i=new X();
        i.g();i.h();
    }
    interface A{}
    private interface B{}
}
class Y implements I.J,I.J.K,X.A
// ,X.B B has private access in X
{}
interface L extends I{ int i=11;
    void m();
}
class C implements L{
    public void g(){}
    public void h(){}
    public void m(){}
    int i=22;
    public static void main(String[] args) {
        C c=new C();
        IO.println(c.i);
        L i=c;
        IO.priintln(l.i);
    }
}