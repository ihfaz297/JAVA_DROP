class A {
  static void staticMethod() {
    System.out.println("Static Method");
  }
}

public class J18A2b {
  public static void main(String[] args) {
    A a = null;
    a.staticMethod();
  }
}
