class Dog{
    String name;
}
public class Dogma {
    public static void main(String[] args) {
        Dog a = new Dog();   // 1 dog, 1 remote
        Dog b = a;           // still 1 dog, now 2 remotes pointing at it
        b.name = "Rex";      // a.name is "Rex" too: same dog
        Dog c = new Dog();   // a second dog
        System.out.println(a == b);               // true : same dog
        System.out.println(a == c);              // false: different dogs, even if identical inside
        System.out.println(a.name);
        a.name="henrietta";
        System.out.println(b.name);
    }
}
