class J18B6c {

  static <T> void reverse(T[] arr) {
    System.out.println("After reverse : ");
    for(int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] arr = { 1 , 2 , 3 , 4 , 5 , 6 , 7 };
    System.out.println("Before reverse : ");
    for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    System.out.println();
    reverse(arr);
    String[] str = { "ABC", "DEF", "GHI", "JKL" };
    System.out.println("Before reverse : ");
    for(int i = 0; i < str.length; i++) System.out.print(str[i] + " ");
    System.out.println();
    reverse(str);
  }
}
