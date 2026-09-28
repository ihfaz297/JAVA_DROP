import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

    void main() throws IOException{
         String s2 = Files.readString(Paths.get("Input.txt"));
        Files.write(Paths.get("Output.txt"),Arrays.asList(s2.toUpperCase()));

    }

