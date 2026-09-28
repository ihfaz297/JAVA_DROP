class J13_5C {
  int x, y; // niche koyekbar y call hoise, tai ekhanei declare kore dilam 
  public static void main(String[] args) {
    int x = 10;
    System.out.println("x is : " + x);
    for(x = 0; x < 3; x++) { // Error -> int x hobe na, jehetu ekbar declare kora hoise x
      int y = -1;
      System.out.println("x is : " + x + " and y is : " + y);
      y = 100;
      System.out.println("x is : " + x + " and y is : " + y);
    }
    x = 20; int y = 50; // int y hobe jehetu main function e y age declare hoy nai 
    System.out.println("x is : " + x + " and y is : " + y);
    J13_5C scm = new J13_5C();
    scm.show();
  }
  class AnotherScope {
    AnotherScope() {
      int y = 8000; x = 3000;
      System.out.println("x is : " + x + " and y is : " + y);
    }
    
  }
  void show() {
    x = 1000; y = 2000;
    System.out.println("x is : " + x + " and y is : " + y);
    new AnotherScope();
  }
}
