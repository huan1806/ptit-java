import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class J07007 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("VANBAN.in");
        try (Scanner sc = new Scanner(file)) {
            TreeSet<String> set = new TreeSet<>();
            while (sc.hasNext()) {
                set.add(sc.next().toLowerCase());
            }
            for (String word : set) {
                System.out.println(word);
            }
        }
    }
}
