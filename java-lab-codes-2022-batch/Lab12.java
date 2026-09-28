public class Lab12 {
    static void m() {int[] a = new int[1];
        // if (true) return;
        try {
            a[2] = 0;
            int i = 5/0;            
        }
        catch (ArithmeticException e){
            System.out.println("m.Catch()");
            // a[2] = 0;
            System.out.println(e);
        }
        // catch (ArrayIndexOutOfBoundsException e){
        //     System.out.println("m.Catch(2)");
        //     // int j = 4/0;
        //     System.out.println(e);
        // }
        finally {
            // int j = 3/0;
            // a[2] = 0;
            System.out.println("finally");
        }
        System.out.println("Between");
        try {System.out.println("m 2nd Try");}
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("m 2nd Catch");}
        finally {System.out.println("m 2nd finally");}
    }
    public static void main(String[] args) {
        System.out.println("Main Start");
        // int i = 5/0;
        try{m();}
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("main.Catch()");
            // int j = 4/0;
            System.out.println(e);
        } 
        System.out.println("Will not Print");
    }    
}