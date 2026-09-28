class A implements Cloneable { int i = 10;
    // void toString(){} // Error
    public String toString() {
        return "Class:A ("+super.toString()+") {i="+i+"}";
        // return super.toString();
    }
    protected A clone() {
        A a = null;
        try{ a = (A)super.clone();} 
        catch(Exception e){}
        return a;
    }
    public boolean equals(Object obj) {
        if (obj instanceof A) {
            A other = (A) obj;
            return i==other.i;
        }
        return false;
    }
    // @Override
    // protected void finalize() throws Throwable {
    //     System.out.println("A Destroyed");
    // }
} class B { int j = 20; }
public class Lab11 {
    static void m(Object o) {
        System.out.println(o instanceof A);
        System.out.println(o instanceof B);
        System.out.println(o instanceof Object);
        // System.out.println(o instanceof Interface);
        System.out.println(o.getClass().getName());
        System.out.println(o);}
    // static void m(B b) // Redundant Code
    public static void main(String[] args) throws Exception {
        A a = new A();
        System.out.println(a);
        // System.out.println(a.toString());
        // System.out.println(a.getClass().getName());
        // System.out.println(a.hashCode());
        // B b = new B();
        // m(a); m(b);
        // A a2 = a.clone();
        // System.out.println(a2);
        // // System.out.println(a2.toString());
        // System.out.println(a2.getClass().getName());
        // System.out.println(a.equals(a2));
        // a2.i++;
        // System.out.println(a.equals(a2));
        // // System.out.println(a.i);
        // System.out.println(a2.hashCode());
        // System.out.println(a==a2);
        a = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("Main End.");

    }
}