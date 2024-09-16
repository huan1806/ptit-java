import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int testNum = sc.nextInt();
            while (testNum-- > 0) {
                int n = sc.nextInt();
                System.out.println((long) n * (n + 1) / 2);
            }
        }
    }
}
