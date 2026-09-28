interface Testing1 {
  void method1();
  void method2();
}
interface Testing2 {
  void methodA();
  void methodB();
}
class MyClass implements Testing1, Testing2 {
  public void method1() { System.out.println("In method1()"); }
  public void method2() { System.out.println("In method2()"); }
  public void methodA() { System.out.println("In methodA()"); }
  public void methodB() { System.out.println("In methodB()"); }
}
class J14_6B {
  public static void main(String[] args) {
    
  }
}
