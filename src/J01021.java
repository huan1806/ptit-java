import java.util.Scanner;

public class J01021 {

    private static final int MODULO = 1000000007;

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            for (; ; ) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                if (a == 0 && b == 0) {
                    break;
                }
                System.out.println(pow(a, b));
            }
        }
    }

    private static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 1) {
            return getProduct(a, pow(a, b - 1));
        }
        long p = pow(a, b / 2);
        return getProduct(p, p);
    }

    private static long getProduct(long a, long b) {
        return ((a % MODULO) * (b % MODULO)) % MODULO;
    }
}
