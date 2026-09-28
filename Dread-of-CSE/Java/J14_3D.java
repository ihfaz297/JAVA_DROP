class Person {
  public void work() {
    System.out.println("Working");
  }
  public void sleep() {
    System.out.println("Sleeping");
  }
}
class Teacher extends Person {
  public void work() {
    System.out.println("Teaching");
  }
  public void work(String course) {
    System.out.println("Teaching " + course);
  }
}

class J14_3D {
  public static void main(String[] args) {
    Person p = new Person();
    p.work(); 
    p.sleep();
    Teacher t = new Teacher();
    t.work("OOP");
    t.sleep();
    t.work();
  }
}
