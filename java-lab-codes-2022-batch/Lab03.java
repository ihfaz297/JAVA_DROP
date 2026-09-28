// import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JOptionPane;

public class Lab03 {
    public static void main(String[] args) throws IOException {
        
        // Input via Console
        // String inputLine = System.console().readLine("Enter a line:");
        // System.out.println(inputLine);

        // Input via GUI
        // String inputLine = JOptionPane
        //     .showInputDialog("Enter a line:");
        
        // Output via GUI
        // JOptionPane.showMessageDialog(null, inputLine+'\n'+inputLine);

        // String splitting
        // String line = JOptionPane
        //     .showInputDialog("Enter Fruits Names:");
        // String[] words = line.split(" ");        
        // System.out.println(Arrays.toString(words));

        // For each loop
        // for(String s: words) System.out.println(s);

        // Multiline GUI output
        // JOptionPane
        //     .showMessageDialog(null, 
        //     line.replaceAll(" ", "\n"));




        // File Read
        // for(String line:Files.readAllLines(
        //     Paths.get("SampleInput.txt"))) 
        //     System.out.println(line);


        // File Write
        String[] lines = {"First line.","2nd line","3","4"};
        Files.write(Paths.get("SampleOutput.txt"),Arrays.asList(lines));

    }
}