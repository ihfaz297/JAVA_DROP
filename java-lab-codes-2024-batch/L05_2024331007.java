/**
 * @LabID: 05
 * @Date: 2026-08-18
 * @RegNo: 2024331007
 * @Section: A
 */


public class L05_2024331007{
    static A a3;
    static {IO.println("MSB1");}
    public static void main(String[] args) {
    //   A a = new A();
    //   A a2 = new A();
    //   IO.println(a);
    //   IO.println(a2);
    //   IO.println(a.i);
    //   a.i =100;
    //   IO.println(a.i);
    //   IO.println(a2.i);
    //   a2=a;
    //   IO.println(a2.i);
    //   a.m();a2.m();

    //   a = new B();error: incompatible types: B cannot be converted to A
    // A.i =50; error: non-static variable i cannot be referenced from a static context
    // A a3; IO.println(a3);error: variable a3 might not have been initialized

    //    IO.println(a3); 
    //    a3 = new A(); a3.i =50;
    //    IO.println(a3.m2(200));
    //    IO.println(a2.m2(200)); new A();

    //  new A(); new A();
    //  IO.println(A.s); A a = new A();
    //  IO.println(a.s); A.s++;IO.println(a.s);
    //  A.m3();a.m3();a.m();
    // IO.println(A.s);new A();
    IO.println("L05.main");
    }

}

class A{int i; static int s =50;
    static {IO.println("SB1");}
        public static void main(String[] args) {
            IO.println("A.main"); main();
        }
    static void main(){IO.println("void.main()");}

    static void m3(){IO.println("Sm3"+s);
        // IO.println(i);error: non-static variable i cannot be referenced from a static context
    }
    // IO.println("Error");error: illegal start of type
    {IO.println("B01"+i); {int z=50;}}
     A(){  IO.println("A()");}
    //  {IO.println(m);}error: illegal forward reference
    {m=10;}
     int m;
     {IO.println(m);}
    //  A(int k){  IO.println("A(k)");}
    
    
     void m(){IO.println("void m()"+s+" "+m);}
     {IO.println("B02");}
    //  {IO.println(z);}error: cannot find symbol
     int m2(int j){ return i+j;}
}

class B{
    public static void main(String[] args) {
        B b = new B();b.m();b.m(10);
        b.m(3.1);b.m("S");b.m(20,"S2");
    }



    void m(){IO.println("B.main()");}
    // int m(){return 10;}error: method m() is already defined in class B
    void m(int i){IO.println("B.m(i)");}
    void m(double d){IO.println("B.m(d)");}
    void m(String s){IO.println("B.m(s)");}
    void m(int i,String s){IO.println("B.m(i,s)");}

}
// class B{} error: duplicate class: B

class C{ int i;

    C(){IO.println("C()");}
    C(int i){this();this.i=i;IO.println("C(i)");}
    C(String s){IO.println("C(s)");}
    void m(){this.i=50;IO.println(i);}
    // static {this.i=10;}
    // static void ms(){this.i=10;}
    // void m2(){this();}error: explicit constructor invocation may only appear within a constructor body
    void v(int... i){
        IO.println(i.length); 
        for (int j:i){
            IO.println(j);
        }
    }
    void v(String... s){IO.println("v(s)");}

    public static void main(String[] args) {
        // new C();new C(10).m();new C("S");
        C c =new C();
        // c.v();error: reference to v is ambiguous
        c.v(10);
        c.v(10,20);c.v(1,2,3,4);

    }
}