import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class gen_test_line_up {

    public static void main(String[] args) throws IOException {
       ArrayList<String> lines = new ArrayList<>();
       lines.add("100000 100000");
       for (int i = 1; i <= 100000; i += 1) {
           String line = "";
           line += i + " " + i;
           lines.add(line);
       }
       Path file = Paths.get("test1.txt");
       Files.write(file, lines, StandardCharsets.UTF_8);
    }
}
