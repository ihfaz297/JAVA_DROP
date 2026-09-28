interface A {
  int i = 10;
  int j = 20;
  interface B { // Error -> private hobe na
    void s();
  }
  void show(String msg);
}
class J13_3B implements A {
  static int k = 30; // Problem -> jehetu E class er s() method static ar s er moddhe k er value dekhabe, tai k o static houa lagbe
  class D implements A.B {
    public void s() { // Error -> public add korte hobe
      System.out.println("i = " + i + " j = " + j + " k = " + k);
    }
    public void change() {
      int i = 20; int j = 10; // Error -> i, j interface er variable tai static & final. Either i, j ei class e k er sathe declare kora lagbe or ei method er vitor int i = 20; int j = 10 evabe lekha lagbe
    }
  }
  static class E {
    static void s() {
      System.out.println("i = " + i + " j = " + j + " k = " + k);
    }
    static void s(String msg) { // Problem -> Eta error na. tbe E.s("Hello") call korte ei method static houa lagbe
      System.out.println(msg);
    }
  }
  public void show(String msg) { // Error -> public add korte hobe
    System.out.println(msg + " " + k);
  }
  String sho(String msg) { return msg + " " + k + " " + i; } // Error -> Same name er different return type er duita method thaka jabe na
  
  public static void main(String[] args) {
    J13_3B c = new J13_3B();
    c.show("Error!");
    System.out.println(c.sho("Hello"));
    D d = c.new D(); // Error -> D class jehetu inner non static class tai etar outer class er reference e call kora lagbe
    d.s();
    d.change();
    E.s("Hello!");
    E.s();
  }
}
