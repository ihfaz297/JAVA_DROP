class A implements Runnable {
    @Override
    public void run() {
        System.out.println("A thread using Runnable");
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        System.out.println("A thread ended.");
    }
    public static void crAndSt(){
        new Thread(new A()).start();        
    }
    public static Thread crAndStAndR(){
        Thread t = new Thread(new A());        
        t.start();
        return t;
    }
}
class B extends Thread {
    @Override
    public void run() {
        System.out.println("B thread using Extend");
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        System.out.println("B thread ended.");
    } 
    public static B createAndStart(){
        B b = new B();
        b.start();
        return b;
    } 
}
public class Lab13 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);
        t.setName("MainThread");
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t);
        // Thread childT = new Thread(new A());
        // childT.start();
        // A.crAndSt();
        Thread childT = A.crAndStAndR();
        // B childT2 = new B();
        // childT2.start();
        Thread childT2 = B.createAndStart();
        Thread childT3 = new Thread() {
            public void run() {System.out.println("Ano thread using Extend");
            try{Thread.sleep(1000);}
            catch(InterruptedException e){}
            System.out.println("Ano thread ended.");};
        }; childT3.start();        
        try{Thread.sleep(1000);childT.join();
            childT2.join(); childT3.join();
        }
        catch(InterruptedException e){}        
        // childT3.start(); //Exception in thread "MainThread" java.lang.IllegalThreadStateException
        System.out.println("Main Thread Ended.");
    }
}