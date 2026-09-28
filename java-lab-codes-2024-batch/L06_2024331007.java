/**
 * @LabID: 06
 * @Date: 2026-09-01
 * @RegNo: 2024331007
 * @Section: A
 */



public class L06_2024331007 {
    public static void main(String[] args) {
        // A a = new A(); a.m();
        // //B b; // error: cannot find symbol
        // A.B b;
        // //b = new B(); // error: cannot find symbol
        // //b = new A.B(); // error
        // b = a.new B();
        // A.C c = new A.C();
        // A  a = new B();
        // IO.println(a.i);
        //IO.println(a.j); //error: cannot find symbol
        // a.m();
        //a.m2();//error: cannot find symbol
        // B b = (B) a;
        // IO.println(b.j);
        // IO.println(b.i);
        // b.m2();
        //C c = (C)b; //error: incompatible types: B cannot be converted to C
        // new C();
        // new A(); //error: A is abstract; cannot be instantiated
        // A a = new B();a.m2();




    }
    
}

// class A{ int i = 10; static int j =20;
//     // Non_static nested class :Inner
//     class B{
//         B() {IO.println("B obj created");
//             IO.println("i="+i);
//             IO.println("j="+j);m2();m3();sm();
//         }
//         static void sm(){IO.println("B.sm");}
//     }


    
//     void m2(){IO.println("A.m2()");}
//      static void m3(){IO.println("A.m3()");}
//     void m () {
//         B b = new B();
//         C c = new C();
//     }
//     // static nested Class
//     static class C{
//         C(){IO.println("C obj created");
//              //IO.println("i="+i); //error: non-static variable i cannot be referenced from a static context
//              IO.println("j="+j); m3();
//              //m2();

//         }  
//     }
// }


// class A {int i = 11; {i++;}
// A(int i){IO.println("A()");}
// {IO.println("A.BL1");}
// void m(){IO.println("A.m()");}
// }

// class B extends A{int j =22;int i =99; {int i=33;this.i = 55;super.i =44;}
// B(){ 
//     IO.println("B()"); int k =123;k++;
//     //j++;//error: cannot reference j before supertype constructor has been called
//     super(10);
//     IO.println("B2()");
// }
// {IO.println("B.BL2");}
// void m(){IO.println("B.m()");}
// void m2(){IO.println("B.m2()");}
// }

// class C extends B{int i =66;
//     C(){
//         IO.println(i);
//         IO.println(super.i);
//         //IO.println(super.super.i);

//     }
// }


// abstract class A{
//     final void m(){IO.println("A.m()");}
//     abstract void m2();
// }

// class B extends A{
//     // void m() {IO.println("B.m()");}//error: m() in B cannot override m() in A
//     void m2() {IO.println("B.m2()");}
// }

// abstract class C extends A{}


// // class X{abstract void m();//error: X is not abstract and does not override abstract method m() in X
// // }


// final class M{}
// // class N extends M{}//error: cannot inherit from final M

class A {int i =20;
    public String toString(){
        return "A class";
    }
}
class B extends A{int j=10;}
class C extends B{int k =30;}

class VarTst{
     static A m(int i ){
        switch (i) {
            case 0: return new A();
            case 1: return new B();
            default : return new C();
            
    
        }
     }
     public static void main(String[] args) {
        // A a = new A();
        // IO.println(a.getClass().getName());
        //   B b = new B();
        // IO.println(b.getClass().getName());
        //   C c = new C();
        // IO.println(c.getClass().getName());
        // // a =b;
        // //  IO.println(a.getClass().getName());
        // //  a =c;
        // //  IO.println(a.getClass().getName());
        //  var x = m(0);
        //  IO.println(x.getClass().getName());
        //  IO.println(x.i);
        //  var y = (B)m(1);
        //  IO.println(y.getClass().getName());
        //  IO.println(y.j);
        //  var z =(C) m(2);
        //  IO.println(z.getClass().getName());
        //  IO.println(z.k);
        //  IO.println(a instanceof A);
        //  IO.println(b instanceof B);
        //  IO.println(b instanceof A);
        //  IO.println(b instanceof C);
        //  IO.print(a);
         P p = new P(){
            void m(){IO.println("Anno.m()");}
         };
         p.m();
    
     }
}

abstract class P{
    abstract void m();
}