class J19A2d {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 1000, 7, 8, 9, 0};
    check(arr);
  }
  static void check(int[] arr) {
    try {
      for(int i = 0; i < arr.length; i++) {
        if(arr[i] == 0) throw new ArithmeticException();
        System.out.println((1.0 / arr[i]));
      }
    } catch (ArithmeticException e) {
      System.out.println("A Zero Is Found!!!");
    }
    finally {
      System.out.println("Array traversing stopped.");
    }
  }
}
