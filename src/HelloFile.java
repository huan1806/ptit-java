import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloFile {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("Hello.txt")), StandardCharsets.UTF_8);
        System.out.println(text);
    }
}
