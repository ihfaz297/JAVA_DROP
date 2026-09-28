class A {
    int i = 10;
    void m(int j) {
        j++;
    }
    void m(A a) {
        a.i++;
    }
    A clone(A a) {
        A b = new A();
        b.i = a.i;
        return b;
    }
    public static void main(String[] args) {
        System.out.println("A.main");
    }
}
public class Lab08_2 {
    public static void main(String[] args) {
        main();
        System.out.println("Lab08_2.main");
        A a = new A();
        System.out.println(a.i);
        a.m(a); // Call by Reference
        // a.m(a.i); // Call by Value
        System.out.println(a.i);
        // A b = a; // not a clone
        A b = a.clone(a);
        System.out.println(b.i);
        b.i++;
        System.out.println(a.i);
    }
    public static void main() {
    }
}