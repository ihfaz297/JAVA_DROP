import java.util.Arrays;



/**
 * @LabId: 04
 * @Date: 2026-06-30
 * @RegNo: 2022331008
 * @Section: A
 */


public class L04_2022331008 {
    public static void main(String[] args) {
        
        IO.println("Hello Word");
        byte bt =10;
        short sh=256;
        int i=54687;
        float f=12.457f;
        double d=789.54879;
        boolean bl=true;
        IO.println("Byte:"+bt);
        IO.println("Byte Max:"+Byte.MAX_VALUE);
         IO.println("Byte Min:"+Byte.MIN_VALUE);
        IO.println("Short:"+sh);
         IO.println("Short Max:"+Short.MAX_VALUE);
          IO.println("Short Min:"+Short.MIN_VALUE);
          //int if;
          //int _; //error:-expected;
          int _=1;
          // _++; //error:underscore not allowed here.
          int __;
          var a =10;// local varriable type Inference
          int var =11;
          var=a+10;
          IO.println(var);
          double $=1.5;
          IO.print($);
          IO.println(123_456_789);
          IO.print(1_23___78__9);
          //IO.println(19_); //error:illegal underscore
          IO.println(0757);
         // IO.println(0_75_7);//error:illegal underscore 
          IO.println(0xaFbc);
          //IO.println(0x_aFbc);//error:illegal underscore
          IO.println(0B010101);
          // IO.println(12345678912);//error:integer number too large 
            IO.println(123456789L);
            IO.println(1.456e-5);
            //IO.println(0x1.456);//error: malformed floating -point literal
            IO.println(0x1.456p2);
            IO.print('\077');
             IO.print('\u0996');
             //IO.print('\u09960');//error:unclosed character literal
             IO.println("""
                     ABC
                     DEF
                     GHI""");
            IO.println("""
                     ABC\
                     DEF\
                     GHI""");
             int[] ar=new int[10];
             for(int i_=1;i_<11;i_++) ar[i_-1]=i_;
             for(int i_=1;i_<10;i_++)
                IO.print(ar[i_]+"");
            IO.println(Arrays.toString(ar));
            for(int j :ar) IO.print(j+" ");
            //type conversion
            byte b =1; int j=1;
           // b = 128; //error: incompatible types:possible lossy conversion from int to byte
           //b=j;
           //b=b+1;
           b++;
          // h/w :byte ,short,char
          b +=1;
          b =5;b += b++ +1;IO.println(b);
          //bl = (boolean) 1; // error : incompatible types : int cannot be converted to boolean
          b = (byte)256; //Narrowing conversion
          System.out.printf("%10d,%10f\n",123,3.14);
          System.out.printf("%010d,%010f\n",123,3.14);
          bl = 1.5==1.500_000_000_000_000_0001;






          
    }
    
}