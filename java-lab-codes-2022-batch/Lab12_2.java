import java.io.IOException;

// class A extends Exception {}
// class A extends Throwable {}
// class A extends Error {}
class A extends Exception { int i = 10;
    A() {}
    A(int i) { this.i = i;}
    public String toString() {        
        return "Custom Exception: ("+i+") "
        +super.toString();
    }
}
// class B extends A {}
class C extends Exception {}

public class Lab12_2 {
    public static void main(String[] args) 
    // {
    throws A, C{
    // throws B {
    // throws A {
    // throws ArithmeticException, ArrayIndexOutOfBoundsException {
        // throw new Throwable();
        // if (true)
        // throw new ArithmeticException();
        // // throw new IOException();
        // // throw new Error();
        // if (true)
        // throw new ArrayIndexOutOfBoundsException();
        // throw new A();
        // try{throw new A();}
        // catch(A e) {System.out.println("Catched "+e);}
        // try{throw new A(50);}
        // catch(A e) {System.out.println("Catched "+e);}
        // throw new B();
        try {
            if (false) throw new A();
            if (true) throw new C();
        } 
        // catch (A|C a) {
        //     System.out.println(a);
        // }
        catch (Exception a) {
            System.out.println(a);
            throw a;
        } 
    }
}