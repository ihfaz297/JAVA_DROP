class TimerThread implements Runnable {
  Thread t;
  TimerThread() {
    t = new Thread(this, "TimerThread");
  }
  public void run() {
    System.out.println("Thread Started"); 
    int i = 1;
    try {
      while(i <= 60) {
        Thread.sleep(1000);
        System.out.println(i);
        i++;
      }
      System.out.println("Thread Stopped");
    } catch (Exception e) {}
  }
}
class ThreadDemo {
  public static void main(String[] args) {
    TimerThread t1 = new TimerThread();
    t1.t.start();
  }
}
