class J19B5a{
  static int a = 3, b;
  static void meth(int x) {
    System.out.println("x = " + x + " a = " + a + " b = " + b);
  }
  static {
    System.out.println("Static block initialized.");
    b = a * 4;
  }
  public static void main(String[] args) {
    meth(42);
  }
}
