public class Lab05_2 {
    public static void main(String[] args) {
        // Control statement
        if(true) System.out.println("A"); else System.out.println("B");
        if(true); else if(false); else;
        if(true); else if(false);
        if(true); else; if(false);
        if(true) if(false); else; else; if(false);
        if(true) if(false); else; else if(false);
        if(true) if(false); else; else if(false); else;
        if(true) if(false); else; else; if(false); else;

        // switch (5-4) case 1:break;default:break; // Error
        switch (5-4) {case 1:break;default:break; }
        switch ('A') {case 1:break;default:break; }
        // switch (1.2) {case 1:break;default:break; } // Error selector type double is not allowed
        // switch (2l-1l) {case 1:break;default:break; } // Error selector type long is not allowed
        // switch ("A") {case 1:break;default:break; } // Error incompatible types: int cannot be converted to String
        switch ("A") {case "B":break;default:break; }
        switch ("A") {case "B":break; }
        switch ("A") {case "B":; }
        switch ("A") { }
        switch ("A") { case "A": case "B": case "C": ;}
        switch ("A") { case "A": case "B": case "C": }
        switch ("A") { default:}

        // Loop
        // while(1); // Error incompatible types: int cannot be converted to boolean
        while (true)break;
        do break;while (true);
        for(;;)break;
        int i = 0;
        for(;;i++)break;
        System.out.println(i);

    }
}