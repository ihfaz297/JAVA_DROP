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
        P p = new P(6);
        // P.Q h = new P.Q();
        // p.m();
        // P.R f = p.new R();
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

class P{
    P(int i){System.out.println(i+" "+"P constructor");}
}
class Q extends P{
    {System.out.println("Q.BLOCK1");}
    Q(int i){super(i);System.out.println("Q constructor");}
}
// for constructors, superclass first, then subclass
class I{
    public static void main(String[] args) {
        P p = new Q(6);
    }
}