public class Refresh {
    int x;  // filed; instance var
    Refresh(int x){     // constructor
        this.x = x;
    }    
    int twice(){return x * 2;}  //method
    public static void main(String[] args){
        Refresh r = new Refresh(21);
        System.out.println(r.twice());

        int[] a = {1,2,3};
        int[] b = new int[5];   // 5 zeros

        System.out.println(a.length + " " + b[4]);

        String s = "hello";
        System.out.println(s.length()+" " + s.charAt(1)+" "+s.toUpperCase()+
        " "+s.substring(1, 3)+" "+s.replace('l', 'L')+ " "+s.indexOf('l'));

        for(int i = 0; i< a.length; i++) System.out.print(a[i]+" ");
        for(int v: a) System.out.println(v+" ");
        System.out.println();

        System.out.printf("%d | %.2f | %s |%02d%n", 7, 3.14159, "str", 5);
        System.out.println(10/4 + " "+10/ 4.0+" "+10%4+" "+(double)(10/4));
        System.out.println(Math.max(3, 8) + " " + Math.abs(-5) + " " + Math.round(2.5) + " " + Math.pow(2, 10));
        String t = (5 > 3)? "yes" : "no";
        System.out.println(("a"+1+2)+" "+(1+2+"a")) ;
    }
}
