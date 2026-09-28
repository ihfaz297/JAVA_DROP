class P {
  int p;
  P(int p) {
    this.p = p;
  }
  void val() {
    System.out.println("P : " + p);
  }
}

class Q extends P {
  int p = 100;
  int q;
  Q(int p, int q) {
    super(p);
    this.q = q;
  }
  void val() {
    System.out.println("P : " + p + ", Q : " + q);
  }
}

class R extends Q {
  int p = 93;
  int r;
  R(int p, int q, int r) {
    super(p, q);
    this.p = p;
    this.r = r;
  }
  void val() {
    System.out.println("P : " + p + ", Q : " + q + ", R : " + r + ", P p : " + super.p);
  }
}

class A {
  public static void main(String[] args) {
    R obj1 = new R(10, 20, 30);
    obj1.val();
    Q obj2 = new Q(50, 60);
    obj2.val();
  }
}
