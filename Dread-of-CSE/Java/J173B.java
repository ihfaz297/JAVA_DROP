interface Exam {
  static int n = 10; //Error -> initialized korte hobe
  void register();
  default void collectTopics() {
    n = 100; //Error -> interface er variable final always.
  }
  static void completeSyllabus(){ }
}
interface Syllabus extends Exam {

}
class TermTest implements Exam {
  public void register() { 
    System.out.println("Study!!!");
  }
  public static void main(String[] args) { // Error -> public static void main(String[] args) { }; static hobe void er age
    TermTest obj = new TermTest();
    obj.collectTopics(); //Error -> collectTopics() method static na -> obj.collectTopics()
    Exam.completeSyllabus(); //Error -> Exam.completeSyllabus()
  }
}
