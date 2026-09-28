class J13_2B {
  public static void main(String[] args) {
    byte b; short s; int i = 259; double d = 321.123;
    b = (byte) i;
    System.out.println("(1) b = " + b + " ## i = " + i);
    i = (int) d;
    System.out.println("(2) i = " + i + " ## d = " + d);
    b = (byte) d;
    System.out.println("(3) b = " + b + " ## d = " + d);
  }
}
