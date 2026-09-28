interface A {
    int a = 10; final int b = 20;
    void am();
}
interface B extends A {
    static int b = 30;
    int c = 50;
    interface C {
        final static int c = 50;
        void am();
        void bm();
    }
    void bm();
}

class J14_4B implements B, B.C { // Error -> ekhane C er poriborte B.C dite hobe
    int a = 60;
    
    public static void main(String[] args) {
        J14_4B inf = new J14_4B();
        inf.am();
        A a = inf; B b = inf; B.C c = inf; // Error -> ekhane C er poriborte B.C dite hobe
        a.am(); b.am(); b.bm(); c.am();
    }
    public void am() { System.out.println("AM = " + B.c); } // Ambiguity error jeno na hoy tai B.c
    public void bm() { System.out.println("BM = " + a); }
}

