public class Lab04 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)Character.MAX_VALUE);
        System.out.println(4565); // Decimal Representation of Integer Literal
        System.out.println(45_6___5); // Decimal Representation of Integer Literal
        // System.out.println(_45_6___5); // Decimal Representation of Integer Literal
        // System.out.println(45_6___5__); // Decimal Representation of Integer Literal
        // System.out.println(45654654545454); // Decimal Representation of Integer Literal
        System.out.println(-4565); // Decimal Representation of Integer Literal
        System.out.println(04565); // Octal Representation of Integer Literal
        System.out.println(00004565); // Octal Representation of Integer Literal
        // System.out.println(08); // Error
        System.out.println(0_4565); // Octal Representation of Integer Literal
        System.out.println(-04565); // Octal Representation of Integer Literal
        System.out.println(0x4abc); // Hexadecimal Representation of Integer Literal
        // System.out.println(0_x4abc); // Hexadecimal Representation of Integer Literal
        // System.out.println(0x_4abc); // Hexadecimal Representation of Integer Literal
        System.out.println(-0x4abc); // Hexadecimal Representation of Integer Literal
        System.out.println(0x4ABC); // Hexadecimal Representation of Integer Literal
        System.out.println(0x4aBc); // Hexadecimal Representation of Integer Literal
        // System.out.println(0x4aBg); // Hexadecimal Representation of Integer Literal
        // System.out.println(0b4aBc); // Error
        System.out.println(0b10101); // Binary Representation of Integer Literal
        System.out.println(0b1____010__________1); // Binary Representation of Integer Literal
        // System.out.println(0b_1____010__________1); // Error

        // Floating Point Literals
        System.out.println(123.545); // Double Representation of Floating Point Literal
        System.out.println(123.545e1); // Double Representation of Floating Point Literal
        System.out.println(123.545e+1); // Double Representation of Floating Point Literal
        System.out.println(123.545e-1); // Double Representation of Floating Point Literal
        System.out.println(1___2__3.5__45e-1___2); // Double Representation of Floating Point Literal
        // System.out.println(123.545_e-1); // Error
        // System.out.println(123.545e_-1); // Error
        // System.out.println(123._545e-1); // Error
        // System.out.println(123_.545e-1); // Error
        System.out.println(0454.3); // No Error
        System.out.println(000000454.3); // No Error
        // System.out.println(0b1010.0); // Error
        System.out.println(123.45f); // Float Representation of Floating Point Literal
        System.out.println(123.45F); // Float Representation of Floating Point Literal
        // System.out.println(123.45_F); // Error
        System.out.println(0x121ab.4abp2); // Hex Representation of Floating Point Literal
        System.out.println(0x121ab.4abp2f); // Hex Representation of Floating Point Literal
        // System.out.println(0x121ab.4abpa2f); // Error
        System.out.println('a'); // Character Literals
        // System.out.println('aa'); // Error
        System.out.println('\067'); // Character Literals
        System.out.println('\123'); // Character Literals
        // System.out.println('\1234'); // Error
        System.out.println('\\'); // Character Literals
        System.out.println('\u45af'); // Character Literals
        // System.out.println('\u45aff'); // Error

        //String Literals
        System.out.println("Abkj ajkdsf j");
        System.out.println("Abkj\n ajk\ndsf j");
        // Error
        // System.out.println("Abkj  
        //  ajk
        //  dsf j");
        System.out.println("""
                Hello multi
                line string
                text block"""); // Text Block representation of String Literal
        System.out.println("""
                Hello multi
                line string\
                text block""");  // EndOfLine Escape Character
    }
    
}