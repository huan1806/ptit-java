import java.util.Scanner;

public class J02106 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += sc.nextInt();
                }
                if (sum > 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
