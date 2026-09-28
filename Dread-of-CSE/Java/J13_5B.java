public class J13_5B implements Runnable {
  
  public J13_5B() {
    Thread t = Thread.currentThread();
    System.out.println("Current Thread: " + t);
    t.setName("ExamThread"); t.setPriority(4);
    System.out.println("Current Thread: " + t);
    printer();
  }

  synchronized public void printer() {
    Thread t = Thread.currentThread();
    System.out.println("Printer: " + t);
  }

  public void run() {
    Thread t = Thread.currentThread();
    System.out.println("Current Thread: " + t);
    try {
      Thread.sleep(1000);
      printer();
    } catch (Exception e) {
      System.out.println("ThreadExam Exiting.");
    }
  }

  public static void main(String[] args) {
    Thread t = new Thread(new J13_5B(), "MainThread");
    System.out.println("Current Thread: " + t);
    t.setPriority(6); t.start();
    try {
      t.join();
    } catch (Exception e) { }
    System.out.println("ThreadMain Exiting");
  }
}
