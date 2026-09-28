public class Lab06 {
    public static void main(String[] args) {
        // B: for (int i=0;i<5;i++) {
        //     for (int j=0;j<5;j++) {
        //         System.out.println(
        //             i+" "+j);                
        //         if (j>2) break B;
        //     }
        // }
        // for (int k=0;k<10;k++)
        // A:for (int i=0;i<10;i++) {
        //     B:for (int j=0;j<10;j++) {
        //         System.out.println(
        //             k+" "+i+" "+j);                
        //         if (j>5) break B;
        //     } if (i>5)break A;
        // }
        // for(;;){break A;} //error: undefined label: A
        // {A: {System.out.println(
        //     "Block Start");
        // if (true) break A;
        // System.out.println(
        //     "Block End");
        // }
        // System.out.println(
        //     "Out of Nested Block");}
        // System.out.println(
        //         "Out of Block");
        // A:for(int i=0;i<5;i++)
        // B:for(int j=0;j<5;j++)
        // for(int k=1;k<5;k++)
        // {if(k%2==0) continue A;
        // System.out.println(
        //     j+" "+k);}
        System.out.println("Before");
        // error: unreachable statement
        // return;
        // System.out.println("After");
        // int i=0;
        if(0==0)return;
        if(true)return;
        System.out.println("After");
        // if(true)System.out.println("After");
        // if(5==5)System.out.println("After");
    }
}