package A.p1;

public class C extends A.p2.B {
    public C(){IO.println("p1.C()");
        // A.p2().B b = new A.p2.B();
        // b.m();
        m();
        //m2(); //error: cannot find symbol
    }
    
}
