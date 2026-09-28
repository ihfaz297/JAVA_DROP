
/**
 * @LabID: 04
 * @Date: 2026-07-07
 * @RegNo: 2024331007
 * @Section: A
 */


public class L04_2024331007 {
    public static void main(String[] args) {
        int i = 5;
        switch (i) {
            case 1: IO.println("case 1");
                 break;
            case 2: IO.println("case 2");
                break;
            case 3: IO.println("case 3");
                 break;
            default:
                IO.println("Default");
                break;
        }

          i = 2;
        switch (i) {
            case 1: IO.println("case 1");
                 break;
            case 2: IO.println("case 2");
               
            case 3: IO.println("case 3");
                 break;
            default:
                IO.println("Default");
                break;
        }

        switch (i*5) {
            case 2: IO.println("Case 2");
                
                break;
            case 10 : IO.println("Case 10");
                break;
            default: IO.println("Default");
                break;
        }

        switch (i*5) {
            case 2: IO.println("Case 2");
                
                break;
            case 5+5 : IO.println("Case 10");
              break;
            default: IO.println("Default");
                break;
        }

        switch (i*5) {
            case 2: IO.println("Case 2");
                
                break;
            // case i+5 : IO.println("Case 10"); // error: constant expression required
             // break;
            default: IO.println("Default");
                break;
        }

        char c = 'A';
        switch (c) {
            case 'A': IO.println("Char A");
                
        }

        // long l = 1L;
        // switch (1L) {
        //     case 1L: IO.println("Long");
                
        // }

        switch (i) {
            case 2 : switch (i) {
                case 2: IO.println("Nested");
              
            }
            
        }

        while(i<5) IO.println(i++);
        while(i>1) {while(c<'F') 
            IO.print((char)c++ + " "); i--;}

        IO.println();
        for (int j=1;j<5;j++){
            if(j==2) break;
            IO.println(j);
        }
          for (int j=1;j<5;j++){
            for(int k=1;k<3;k++){
                if(j==2) break ;
                IO.print(k + " ");
            }
          
        }

       for (int j=1;j<5;j++){
            for(int k=1;k<3;k++){
                if(k==2) continue ;
                IO.print(k + " ");
            }
          
        }


         IO.println();
       A: for (int j=1;j<5;j++){
            for(int k=1;k<3;k++){
                if(j==2) break A;
                IO.print(k + " ");
            }
          
        }

       B: for (int j=1;j<5;j++){
            for(int k=1;k<3;k++){
                if(j==2) continue B;
                IO.print(k + " ");
            }
          
        }

      C:{
        IO.println("\nBlock A");
        {
            IO.println("Nested A");
            // break; // error: break outside switch or loop
            //continue; //error: continue outside of loop
           if(true) break C;
           //if(true) break D; //error: undefined label: D
        //    if(true) continue C; // error: not a loop label: 
        }
        IO.println("Block A End");
    }
      
      D:{
        IO.println("Block B");
        {
            IO.println("Nested B");
        }
        IO.println("Block B End");
      }




        


    }
    
}

