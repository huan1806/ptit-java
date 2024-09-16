import java.util.Scanner;

public class J02008 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            long[] gcdArr = new long[101];
            gcdArr[1] = 1;
            for (int i = 2; i < gcdArr.length; i++) {
                gcdArr[i] = gcd(i, gcdArr[i - 1]);
            }
            while (t-- > 0) {
                int n = sc.nextInt();
                System.out.println(gcdArr[n]);
            }
        }
    }

    private static long lcm(long a, long b) {
        return b == 0 ? a : lcm(b, a % b);
    }

    private static long gcd(long a, long b) {
        return a * b / lcm(a, b);
    }
}
