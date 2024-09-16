import java.util.Scanner;

public class J01014 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(getMaxPrimeFactor(n));
        }
        sc.close();
    }

    private static long getMaxPrimeFactor(long n) {
        int lastPrime = 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                lastPrime = i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        return lastPrime > n ? lastPrime : n;
    }
}