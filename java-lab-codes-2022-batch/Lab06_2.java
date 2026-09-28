class A { int a; char c; A aa;}
// class A { int a; }
class Lab06_2 { int a;
    // a = 2; Error
    // System.out.println();Error
    public static void main(String[] args) {
        A a; int i;
        // System.out.println(a);
        // System.out.println(i); //error: variable i might not have been initialized
        a = new A();
        System.out.println(a);
        System.out.println(new A());
        System.out.println(a.a);
        a.a += 10;
        System.out.println(a.a);
        System.out.println(a.c);
        System.out.println(a.aa);
        A b = new A();
        b.a = 100;
        System.out.println(a.a);
        // A c; c.a = 10; //error: variable c might not have been initialized
        A c; c = a; c.a+=20; System.out.println(a.a);
        System.out.println(c); System.out.println(a);
    }
}