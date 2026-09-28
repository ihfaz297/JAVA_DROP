class A { int v; 
    void m(){} 
void m2() {System.out.println("From M2");}
void m3(int i) { System.out.println("From M3: i="+i);}
int m4(int i) { return i*i; } 
void m5() { m3(m4(10)); } 
void m6() { System.out.println(v); } 
void m7(int v) { System.out.println(v+" "+this.v); System.out.println(this);}
 }
class Lab07 { //A a;
    // void m() { a.m(); } // Runtime error Null reference
    public static void main(String[] args) {
        // A.m(); // error: non-static method m() cannot be referenced from a static context
        // m(); //error: cannot find symbol
        // int i; i++;
        // A a; a.m(); // error: variable a might not have been initialized
        // a.m();  // error: non-static variable a cannot be referenced from a static context
        A a = new A(); 
        // A.m();
        a.m(); a.m2(); a.m3(10); System.out.println("From M4:"+a.m4(5));
        a.m5();  a.v = 10; a.m6();
        System.out.println(a);
        a.m7(100);
        A b = new A(); b.v = 20; b.m6(); b = a; b.m6(); a.v+=20; b.m6();
        // System.out.println(b);
        // b.m7(200);

    }    
}