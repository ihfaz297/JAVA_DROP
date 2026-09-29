class Flat{
    static int cnt = 10;

    int num;

    Flat(){cnt++; num=cnt;}
    static int howMany(){return cnt;}
    String show(){return num+"/"+cnt;}
    int flat_no(){return this.num;}
    static int total(Flat a, Flat b){
        return a.num + b.num;
    }
}
public class Sample {
    public static void main(String[] args) {
        Flat f =  new Flat();
        System.out.println("Isn't it funny that an ex-con like me\n owns "+Flat.howMany()+" flats now?...Like.. "+f.cnt+", could you believe?");
        Flat.cnt = 65;
        Flat g = new Flat();
        System.out.println(Flat.howMany());
        // System.out.println();
        System.out.println(Flat.total(f, g));
    }
}
