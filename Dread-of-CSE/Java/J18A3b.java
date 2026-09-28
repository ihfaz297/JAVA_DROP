import java.lang.Math;

class Match {
  int goal = 0;
  boolean isKicked = false;
  char player, keeper;

  synchronized void kick(int n) {
    while(isKicked) {
      try { wait(); }
      catch(Exception e) { }
    }
    if(n == 3 || n == 5) player = 'L';
    else player = 'R';
    System.out.println("========= Pentlty ===========");
    System.out.print("Player : " + player + " | ");
    isKicked = true;
    notify();
  }

  synchronized void save(int n) {
    while(!isKicked) {
      try { wait(); } 
      catch (Exception e) { }
    }
    if(n == 3 || n == 5) keeper = 'L';
    else keeper = 'R';
    if(player != keeper) goal++;
    System.out.println("Keeper : " + keeper);
    System.out.println("Goal : " + goal);
    isKicked = false;
    notify();
  }
}

class Player implements Runnable {
  Match m;
  Thread t;
  Player(Match m) {
    this.m = m;
    t = new Thread(this, "Player");
  }
  public void run() {
    for(int i = 0; i < 5; i++) {
      m.kick((int)(Math.random() * 6) + 1);
    }
  }
}

class Keeper implements Runnable {
  Match m;
  Thread t;
  Keeper(Match m) {
    this.m = m;
    t = new Thread(this, "Keeper");
  }
  public void run() {
    for(int i = 0; i < 5; i++) {
      m.save((int)(Math.random() * 6) + 1);
    }
  }
}

class J18A3b {
  public static void main(String[] args) {
    Match m = new Match();
    Player p1 = new Player(m);
    Keeper k1 = new Keeper(m);
    p1.t.start(); k1.t.start();
  }
}
