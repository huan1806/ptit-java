import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07022 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("DATA.in"))) {
            List<String> list = new ArrayList<>();
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    sc.nextInt();
                } else {
                    list.add(sc.next());
                }
            }
            list.stream().sorted().forEach(s -> System.out.print(s + " "));
        }
    }
}
