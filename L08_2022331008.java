/**
 * @LabID: 08
 * @Date: 2026-09-16
 * @RegNo: 2022331008
 * @Section: B
 */
public class L08_2022331008 {
    public static void main(String[] args) {
        // I i=new I();I is abstract; cannot be instantiated
        IO.println("Main start");
        try {
//if(true) return;    // even for return in try block, final gets executed
            //System.exit(0); // only system.exit can kill finally
            if(args.length!=0){System.out.println(1/0);}
            else{int[] z={1,2,3,4,5};IO.println(z[6]);System.out.println(1/0);}
        }
        catch(ArithmeticException e){IO.println(e);}
        catch(RuntimeException e){IO.println(e);
            //IO.print(1/0);  // even for exception in catch block, final gets executed
        }
        finally{IO.println("Finally block");}
        try{var n = new NullPointerException("Fidraus");
        var a = new ArithmeticException("Fidraus");
        a.initCause(n);
        throw a;}catch(ArithmeticException e){IO.println(e);}
        IO.println("Main end");



        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
        Counter x = new Counter();
        T3 t3 = new T3(x);
        t3.start();
        T3 t4 = new T3(x);
        t4.start();
        IO.println("Counter value: " + x.s);
           }
}
class G{
    public static void main(String[] args){
        try {
            IO.println("G.main() start");
            throw new ArithmeticException("G.main() ArithmeticException");
        }
        catch (ArithmeticException e) {
            IO.println(e);
        }
    }
}

class B extends Exception {
    B(String message) {
        super(message);
    }
    public String toString() {
        return "B Exception: " + getMessage();
    }
}

class NewClass {
    public static void main(String[] args) {
        try {
            throw new B("Custom exception B");
        } catch (B e) {
            IO.println(e);
        }
    }
}
class I{
    public static void main(String[] args) {
        var n = new NullPointerException("Fidraus");
        var a = new ArithmeticException("Fidraus");
        a.initCause(n);
        throw a;
    }
}
class J {
    public static void main(String[] args) {
        int MAX_PRIORITY = 10;
        Thread t = Thread.currentThread();
        IO.println("Thread name: " + t.getName());
        IO.println("Thread priority: " + t.getPriority());
        t.setName("J.main");
        t.setPriority(MAX_PRIORITY);
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            IO.println(e);
        }
        IO.println(t.getName());
        IO.println("Thread priority: " + t.getPriority());

    }
}
class T1 extends Thread {
    public void run() {
        IO.println("T1.run() start");
        for (int i = 0; i < 5; i++) {
            IO.println("T1.run() " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                IO.println(e);
            }
        }
        IO.println("T1.run() end");
    }
}
class T2 extends Thread {
    public void run() {
        IO.println("T2.run() start");
        for (int i = 0; i < 5; i++) {
            IO.println("T2.run() " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                IO.println(e);
            }
        }
        IO.println("T2.run() end");
    }
}

class Counter{
    int s = 0 ;
    public void m(){s++;}
}
class T3 extends Thread{
    Counter c;
    T3(Counter cc){c=cc;}
    public void run(){
        for(int i=0;i<10000;i++){synchronized(c){c.m();}}
    }
}