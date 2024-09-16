import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("DATA.in"))) {
            long sum = 0;
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    sum += sc.nextInt();
                } else {
                    sc.next();
                }
            }
            System.out.println(sum);
        }
    }
}
