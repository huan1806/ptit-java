import java.util.Arrays;
import java.util.Scanner;

public class J03032 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String s = sc.nextLine();
                String[] words = s.trim().split("\\s+");
                Arrays.stream(words).map(word -> new StringBuilder(word).reverse().toString())
                        .forEach(reversed -> System.out.print(reversed + " "));
                System.out.println();
            }
        }
    }
}
