class A {public int i; private int pi; int di;
    // private void pim() {System.out.println(pi);}
    // static void m() {System.out.println("m()");}
    void m(int ... i) {
        System.out.println("int...i:"+i.length);
        for (int j : i) {
            System.out.println(j);
        }
    } 
    void m (int i, int ... j) {
        System.out.println("int...i,j");
    }
    void m(float ... f){
        System.out.println("float...f");
    }
    void m(A ... a){}
}
public class Lab09_2 {
    // public static void main(String ... args) {}
    public static void main(String[] args) {
        // int i=0; i += ++i;
        // i= i + ++i + i ;
        //  System.out.println("I:"+i);
        // i = 0;
        // A.m();
        A a = new A(); a.i++; a.di++; //a.pim();
        // a.pi++;//error: pi has private access in A
        // a.m();
        // a.m(0);
        // a.m(0,1);
        // a.m(0,1,12,32,545);
        a.m(new A());
        a.m(new A(),new A());
    }    
}