import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                BigInteger num1 = sc.nextBigInteger();
                BigInteger num2 = sc.nextBigInteger();
                System.out.println(lcm(num1, num2));
            }
        }
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(gcd(a, b));
    }
}
