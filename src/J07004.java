import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07004 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("DATA.in");
        try (Scanner sc = new Scanner(file)) {
            int[] count = new int[1001];
            while (sc.hasNextInt()) {
                count[sc.nextInt()]++;
            }
            for (int i = 0; i < 1001; i++) {
                if (count[i] > 0) {
                    System.out.printf("%d %d%n", i, count[i]             );
                }
            }
        }
    }
}
