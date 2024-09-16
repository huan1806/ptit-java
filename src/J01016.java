import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int count = 0;
            long n = sc.nextLong();
            while (n > 0) {
                int digit = (int) (n % 10);
                n /= 10;
                if (digit == 4 || digit == 7) {
                    count++;
                }
            }
            if (count == 4 || count == 7) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
