class J14_2B {
  { System.out.println("B1 : Exam Started!"); }
  static int a;
  static int s = 33;
  J14_2B(int a) {
    this.a = a;
    System.out.println("B2 : Inside Constructor");
  }
  {
    a = 11; s = 22;
    System.out.println("B3 : a = " + a);
  }
  void m() {
    System.out.println("M1 : a = " + a);
  }
  static {
    System.out.println("B4 : a = " + a + ", s = " + s);
  }
  static void sm(int a, int s) {
    System.out.println("M2 : a = " + a + ", s = " + J14_2B.s);
    J14_2B.s = a + s;
  }
  { s += 44; }
  static {
    System.out.println("B5 : s = " + s);
  }

  public static void main(String[] args) {
    System.out.println("Main Started");
    J14_2B.sm(20, 10);
    J14_2B b = new J14_2B(30);
    b.m(); b.sm(50, 40);
    {
      System.out.println("B6 : Exam Ended!");
    }
  }
}
