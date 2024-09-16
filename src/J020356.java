import java.util.Scanner;

public class J020356 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            if (!isValid(n, s)) {
                System.out.print("-1 -1");
            } else {
                String min = getMin(n, s);
                String max = getMax(n, s);
                System.out.print(min + " " + max);
            }
        }
    }

    private static boolean isValid(int n, int s) {
        if (n == 1) {
            return s <= 9;
        }
        return 1 <= s && s <= 9 * n;
    }

    public static String getMax(int n, int s) {
        StringBuilder sb = new StringBuilder(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int digit = Math.min(9, s - sum);
            sum += digit;
            sb.append(digit);
        }
        return sb.toString();
    }

    public static String getMin(int n, int s) {
        StringBuilder sb = new StringBuilder(n);
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int digit = Math.min(9, s - sum - 1);
            sum += digit;
            sb.append(digit);
        }
        sb.append(s - sum);
        return sb.reverse().toString();
    }
}
