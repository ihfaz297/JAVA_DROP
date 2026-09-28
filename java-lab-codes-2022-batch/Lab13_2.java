class A {
    // synchronized void m(String msg) {
    void m(String msg) {
        System.out.println("Printing The Msg:");
        try { Thread.sleep(2000);} catch (InterruptedException e) {}
        System.out.println(msg);
        System.out.println("Printing Done");
    }
}
public class Lab13_2 {
    public static void main(String[] args) {
        A a =new A();
        Thread t = new Thread() { public void run() {
            // a.m("Thread1");
            synchronized (a){a.m("Thread1");}
        };};
        t.start();
        Thread t2 = new Thread() { public void run() {
            // a.m("Thread2");
            // synchronized (a){a.m("Thread2");}
            a.m("Thread2");
        };};
        t2.start();
        try{t.join(); t2.join();} catch (InterruptedException e){}
        System.out.println("Main Ended.");
        
    }
}
