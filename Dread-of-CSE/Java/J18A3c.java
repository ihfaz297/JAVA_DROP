class J18A3c {
  public static void m() { throw new NullPointerException("Null"); }
  public static void m(int e) {
    try {
      System.out.println("e = " + e);
      return;
    }
    finally {
      System.out.println("Not-Reachable!");
    }
  }
  public static void main(String[] args) {
    int e = args.length;
    System.out.println("Total Exception: " + e);
    if(e == 0) e = 10 / e;
    try {
      if(e == 1) e = e / (e - e);
      try {
        if(e == 2) {
          int[] a = {1}; a[1] = 99;
          System.out.println("a[1] = " + a[1]);
        }
        else if(e == 3) m();
        else m(e);
      }
      catch(ArrayIndexOutOfBoundsException ex) {
        System.out.println("Divide by 0");
      }
      finally {
        System.out.println("Un-reachable code");
      }
    }
    catch(ArithmeticException | NullPointerException ex) {
      System.out.println("Array index out-of-bounds or Null");
    }
    catch (Exception ex) {
      System.out.println("Any Exception");
    }
    finally {
      System.out.println("Program Completed");
    }
    System.out.println("Exam Ended");
  }
}
