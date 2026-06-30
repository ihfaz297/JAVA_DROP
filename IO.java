public class IO {
    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static String readLine() throws Exception {
        return new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
    }
}
