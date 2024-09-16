import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class J07085 {
    public static void main(String[] args) {
        solve();
    }

    @SuppressWarnings("unchecked")
    private static void solve() {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("DATA.in")))) {
            List<String> lines = (ArrayList<String>) ois.readObject();
            lines.forEach(line -> {
                StringBuilder num = new StringBuilder();
                int sum = 0;
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c) && (c != '0' || num.length() != 0)) {
                        num.append(c);
                        sum += c - '0';
                    }
                }
                System.out.println(num + " " + sum);
            });
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
