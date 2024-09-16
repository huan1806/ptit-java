import java.util.Scanner;

public class J01022 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        long[] f = getFibonacciArray();
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long k = sc.nextLong();
                System.out.println(digit(n, k, f));
            }
        }
    }

    private static long[] getFibonacciArray() {
        long[] f = new long[93];
        f[1] = 1;
        for (int i = 2; i < 93; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    private static int digit(int n, long k, long[] f) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        long l = f[n - 2];
        if (k > l) {
            return digit(n - 1, k - l, f);
        }
        return digit(n - 2, k, f);
    }
}
