public class Lab05 {
    public static void main(String[] args) {
        int a, b = 8, c = 4;
        a = b+c;
        System.out.println(a);
        a = b+c-5*8/2*2%2;
        System.out.println(a);
        a += --b+--c+ ++c+a++;
		System.out.printf("a=%d, b=%d, c=%d%n",a,b,c);
        char ch = 'A';
        System.out.println(++ch);
        System.out.println(--ch);
        System.out.println(ch-1);
        System.out.println(ch+5);
        System.out.println(ch/2);
        System.out.println((char)(ch/2));
        // boolean bl = true+true; // Error bad operand types for binary operator '+'
        boolean bl = 5>10; bl = 5>=10; bl = 5<=10; bl = 5==10; bl = 5!=10;
        System.out.println(bl);
        bl = 2.5==2.50000001;
		System.out.println(bl);
        bl = 1.123==1.123; bl = 'A'>'a';
        bl = true==true; bl = true!=false;
        // bl = true>false; //Error bad operand types for binary operator '>'
        // bl = true<=false; //Error bad operand types for binary operator '<='
        System.out.println(bl);

        // bitwise operator
        byte bt = 4 & 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(bt));
        bt = 4 | 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(bt));
        bt = 4 ^ 5;
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(bt));
        System.out.println(Integer.toBinaryString(~bt));
        System.out.println(~bt);
        System.out.println('A'&'B');
        // System.out.println(1.1&2.1); // Error bad operand types for binary operator '&'
        System.out.println(1L&2L);
        System.out.println(true & false);
        System.out.println(5==5 & 5>6);
        // System.out.println(5>5 & 5/0==0); // Runtime Error
        System.out.println(5>5 && 5/0==0);

        a = 4==0 ? 5 : 10;
        System.out.println(a);
    }
}