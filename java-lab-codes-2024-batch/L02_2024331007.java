import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * @LabID: 01
 * @Date: 2026-06-16
 * @RegNo: 2024331007
 * @Section: A
 */


public class L02_2024331007 {
    public static void main(String[] args) throws IOException {
        IO.print("IO_print");
        IO.print("IO print 2\n");
        IO.println("LAB 02");
        System.out.print("System_print");
        System.out.println("Old System Print");
        int a =10;
        IO.println(a);
        String s = "Str4564";
        IO.println(s);
        s = IO.readln("Enter a fruit name:");
        IO.println(s);
        a = Integer.parseInt(IO.readln("Enter an int:"));
        IO.println(a*10);
        double d =Double.parseDouble(IO.readln("Enter a double:"));
        IO.println(d/30);
        int i = Integer.parseInt(args[0]);
        if(i%2==0)
            IO.println("EVEN");
        else
            IO.println("ODD");
        IO.println(args[0]);
        int i2 = Integer.parseInt(JOptionPane.showInputDialog("Enter an int:"));
        IO.println(i2-50);
        JOptionPane.showMessageDialog(null,i2-50,"Title",1);
        String s2 = Files.readString(Paths.get("Input.txt"));
        Files.write(Paths.get("Output.txt"),Arrays.asList(s2.toUpperCase()));
        for(int i3=0;i3<10;i3++)
            IO.println("*".repeat(10));
        String s3 = IO.readln();
        String[] nums = s3.split(" ");
        IO.println(Arrays.stream(nums).mapToInt(Integer::parseInt).sum());
        IO.println(Arrays.stream(nums).mapToInt(Integer::parseInt).average().getAsDouble());

    }
}
