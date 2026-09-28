// class A { A(){ System.out.println("A() constructor");} }
class B { B(){System.out.println("B() constructor");}
    void B(){System.out.println("B() method");} }
// class A { A(int i) {System.out.println("A(int i)="+i);} }
// class A { int i;i=50; A(){ System.out.println("A() constructor"); } } // Error
// class A { int i=50; A(){ System.out.println("A() constructor"); } }
// class A { int i; A(){ System.out.println("A() constructor"); i = 100;} }
// class A { int i=50; A(){ System.out.println("A() constructor"); i = 100;} }
class A { int i; A(int i){ System.out.println(this.i); this.i = i; 
    System.out.println("A() constructor,i="+this.i);} }
class lab07_2 {
    public static void main(String[] args) {
        // new A();
        // A a = new A();
        // A b; 
        B b = new B(); b.B();
        // A a = new A(100); new A(200); 
        // new A(); // Error:actual and formal argument lists differ in length
        // A a = new A(); System.out.println(a.i);
        A a = new A(100); System.out.println(a.i);
    }
}