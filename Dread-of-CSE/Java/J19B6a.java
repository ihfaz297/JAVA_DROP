class J19B6a {

  static <T extends Comparable<T>> T minimum(T a, T b, T c) {
    T min;
    if(a.compareTo(b) < 0) min = a;
    else min = b;
    if(min.compareTo(c) < 0) return min;
    else return c;
  }

  public static void main(String[] args) {
    System.out.println("Min : " + minimum(-3, 40, 15));
    System.out.println("Min : " + minimum(16.6, 8.8, 7.7));
    System.out.println("Min : " + minimum("mango", "guava", "orange"));
  }
}
