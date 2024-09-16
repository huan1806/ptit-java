import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class J07001 {
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        try (Scanner scanner = new Scanner(new File("DATA.in"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
