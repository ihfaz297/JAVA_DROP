import java.io.PrintStream;
class MySystem {
  static PrintStream out = System.out;
}

public class J18A2c{
  public static void main(String[] args) {
    MySystem.out.println("Static Method");
  }
}
