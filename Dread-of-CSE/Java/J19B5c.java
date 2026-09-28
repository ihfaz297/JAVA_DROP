class SuperClass {
  public void print() {
    System.out.println("From Super Class");
  }
}

class SubClass extends SuperClass {
  public void print() {
    System.out.println("From Sub Class");
  }
  public void anotherPrint() {
    System.out.println("From Sub Class Another Print");
  }
}

class J19B5c {
  public static void main(String[] args) {
    SuperClass s1 = new SubClass();
    s1.print();
    SubClass s2 = (SubClass) s1;
    s2.print(); s2.anotherPrint();
  }
}
