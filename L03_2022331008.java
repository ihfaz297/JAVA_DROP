import java.util.Arrays;
/**
* @LabID: 03
* @Date: 2022-06-30
* @RegNo: 2022331008
* @Section: B
*/
class L03_2022331008 {
    public static void main(String[] args) {
        // Primitive Types
        byte bt  = 10;
        short sh = 256;
        int i = 54687;
        float f = 12.457f;
        double d = 789.54879;
        boolean bl = true;
        IO.println("Byte: " + bt);
        IO.println("Byte Max: " + Byte.MAX_VALUE);
        IO.println("Byte Min: " + Byte.MIN_VALUE);
        IO.println("Short: " + sh);
        IO.println("Short Max: " + Short.MAX_VALUE);
        IO.println("Short Min: " + Short.MIN_VALUE);
        // int if;
        // int _ ; error: = expected
        // int _ = 1;
        // _++; // error: underscore not allowed here
        int __;
        var a = 10; // local variable type inference
        int var = 11;
        var = a + 10;
        IO.println(var);
        double $  = 1.5;
        IO.println($);
        IO.println(123_456_789);
        IO.println(1_23_456____78___9);
        // IO.println(19_); // error: illegal underscore
        IO.println(0757);
        IO.println(0_75_7);
        IO.println(0xaFbc);
        // IO.println(0_xaFbc); // error: illegal underscore
        IO.println(0B010101);
        // IO.println(12345678912); // error: integer number too large
        IO.println(12345678912L);
        IO.println(1.456e5);
        IO.println(1.456e-5);
        // IO.println(0x1.456); error: malformed floating-point literal
        IO.println(0x1.456p2);
        IO.println('\077');
        IO.println('\u0996');
        IO.println('\u0996');
        // IO.println('\u09960'); // error: too many characters in character literal
        IO.println("\"ABC\"");
        IO.println("""
            ABC\
            DEF\
            GHI""");
        int[] ar = new int[10];
        for (int i_ = 1; i_ < 11; i_++) ar[i_ - 1] = i_;
        for (int i_ = 0; i_ < 10; i_++) 
            IO.print(ar[i_] + " ");
        IO.println(Arrays.toString(ar));

    }
}