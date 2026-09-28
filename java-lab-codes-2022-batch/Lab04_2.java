import java.util.Arrays;

public class Lab04_2 {
    public static void main(String[] args) {

        // byte bt;
		// short sh;
		// int i;
		// long l;
		// float f;
		// double d;
		// char c;
		// boolean bl;
		// int var;

		// System.out.println("Default Value Of Byte = "+bt);
        // System.out.println("Default Value Of Short = "+sh);
        // System.out.println("Default Value Of Int = "+i);
        // System.out.println("Default Value Of Long = "+l);
        // System.out.println("Default Value Of Float = "+f);
        // System.out.println("Default Value Of Double = "+d);
        // System.out.println("Default Value Of Char = "+c);
        // System.out.println("Default Value Of Boolean = "+bl);

        byte b;
        // System.out.println(b); // Error for not initialization
        b = 127;
        System.out.println(b);
        // b = 128; // Error for lossy conversion
        b = 045; b = 0x1a; b = 0b1001;
        b = (byte)128;
        System.out.println(b);
        // short sh = 45434; // Error
        int i = (int)5464654654654354L;
        i = (int)454.45;
        System.out.println(i);
        i = 2_123_123_123+2_123_123_123;
        // i = 1l; // Error
        System.out.println(i);
        Long l = 2_123_123_123l+2_123_123_123;
        System.out.println(l);
        b = 127; //b = b+b;//b = b + 2;
        b++;// b = b+1;
        System.out.println(b);

        float f = 3.5f;
		// f = 3.5; // Error possible lossy conversion from double to float

        double d = 3.5; d = 3.5f; d = 123123;


        char c = 'a';
		c = 15; c = 0b1010; c = 0146; c = 0xabf;
		// c = 100000; // Error possible lossy conversion from int to char
		c = (char)100000;
		c = (char)(Character.MAX_VALUE+1);
        System.out.println("Char:"+c+","+(int)c);

        boolean bn = true;
		// bn = (boolean)1; // Error int cannot be converted to boolean
		// bn = (boolean)0; // Error int cannot be converted to boolean
		// bn = (boolean)"true"; // Error String cannot be converted to boolean
        // i = (int)true; // Error boolean cannot be converted to int

        // int[] a = new int[]; //Error
        int[] a;
        // System.out.println(a); // ERROR variable a might not have been initialized
        // a = new int[]; // ERROR array dimension missing
        // a = new long[5]; // error: incompatible types: long[] cannot be converted to int[]
        // a = new byte[5]; // error: incompatible types: byte[] cannot be converted to int[]
        int s = 10;
        a = new int[s];
        System.out.println(a);
        System.out.println("Inside Array a : "+Arrays.toString(a));
        a[0] = 545;
        // a[13] = 10; // java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 10
        int[][] aa1 = new int[4][4];
        // int[][] aa2 = new int[][]; // Error
        int[][] aa2 = new int[4][];
        int[][][] aa3 = new int[4][][];
        int[][][] aa4 = new int[4][5][6];
        int[][][] aa6 = new int[4][5][];
        // int[][][] aa5 = new int[4][][6]; // Error

        byte[] bt = new byte[5];
        System.out.println("Inside Array bt : "+Arrays.toString(bt));
        char[] ca = new char[5];
        System.out.println("Inside Array c : "+Arrays.toString(ca));
        boolean[] bl = new boolean[5];
        System.out.println("Inside Array bl : "+Arrays.toString(bl));
        String[] sa = new String[5];
        System.out.println("Inside Array s : "+Arrays.toString(sa));
    }
}