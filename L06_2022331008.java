/**
 * @LabId: 06
 * @Date: 2026-09-02
 * @RegNo: 2022331008
 * @Section: B
 */
public class L06_2022331008 {
    public static void main(String[] args) {
        // P.Q.sqm();
        // P.sm2();
        
        // P.Q h = new P.Q();
        // p.m();
        // P.R f = p.new R();




        // P p = new P(6);
        // P k = new Q(9);




        // P p = new P();
        // System.out.println(p.getClass().getName());
        // Q q = new Q();
        // System.out.println(q.getClass().getName());
        // R r = new R();
        // System.out.println(r.getClass().getName());



    }
}
// class P{   private int i=10; static int j = 20;
//     // static nested



//     // inner class can access all vars, including private
//     static class Q {
//         Q(){System.out.println("Q created");
//         //static class can access only static vars
//             System.out.println("j="+j); sm2();
//             //static context can't use non-static
//             //P p = new P(); p.m2(); wont work
//         }
//         void qm(){}
//         static void sqm(){}
//     }
//     // non static
//     class R{R(){System.out.println("R created");
//     //non-static can access any var unless out of scope
//         System.out.println("j="+j);
//         System.out.println("i="+i);
//     }}
//     void m(){
//         Q q  = new Q();
//         R r = new R();
//     }
//     void m2(){System.out.println("P.m2()");}
//     static void sm2(){System.out.println("P.sm2()");}
// }

// class P{int i = 11;
//     P(int i){System.out.println(i+" "+"P constructor");}
// }
// class Q extends P{
//     int i = 11;
//     {System.out.println("Q.BLOCK1"+i);}
//     // int i  = 22; i++;
//     Q(int i){
//         super(i);System.out.println("Q constructor");
//         System.out.println("i="+i);
//         System.out.println("Q.i = "+this.i);
//         // System.out.println("P.i="+ ne);
//     }
// }
// // for constructors, superclass first, then subclass
// class I{
//     public static void main(String[] args) {
//         P p = new Q(6);
//     }
// }
// abstract class P{abstract void m();}
// // error: class M is not abstract and does not override abstract method m()
// abstract class M extends P{
    
// }
// abstract class N{}




// class Q extends P{
//     void m(){System.out.println("Q.m()");}
//     void m2(){System.out.println("Q.m2()");}
// }


// final class X{}
// // class Y extends X{} 
// //error: cannot inherit from final class
// class A{public static void main(String[] args) {
//     // new N();
//     P p = new Q();
//     p.m();

// }}


// class P{int i = 11;}
// class Q extends P{ int j =22;}
// class R extends Q{int k = 33;}
// class V{
//     static P m(int i){
//         switch(i){
//             case 1: return new P();
//             case 2: return new Q();
//             case 3: return new R();
//             default: return null;
//         }}
//     public static void main(String[] args) {
//         P p = new P();
//         P p2=new P();
//         System.out.println(p.getClass().getName());
//         Q q = new Q();
//         System.out.println(q.getClass().getName());
//         R r = new R();
//         System.out.println(r.getClass().getName());
//         var n2= m(1);
//         System.out.println(n2.getClass().getName());
//         var n3= m(2);
//         System.out.println(n3.getClass().getName());
//         var n4= m(3);
//         System.out.println(n4.getClass().getName());
//         System.out.println(n2.i);
//         // System.out.println(n3.j);
//         // System.out.println(n4.k);
//         System.out.println(p instanceof P);
//         System.out.println(p instanceof Q);
//         System.out.println(q instanceof P);
//         System.out.println(p.equals(n4));
//         System.out.println(p2.hashCode());
//         T t =  new T();
//         System.out.println(t);
//         System.out.println(t.toString());
//     }
// }
// class T{
//     public String toString(){return "T class";}
// }

abstract class P{
    abstract void m();
}
class A{
    public static void main(String[] args) {
        P p= new P(){
            void m(){System.out.println("Ann.m");}
        };
        p.m();
    }
}