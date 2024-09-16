import java.math.BigInteger;
import java.util.Scanner;

public class J03039 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                BigInteger num1 = sc.nextBigInteger();
                BigInteger num2 = sc.nextBigInteger();
                if (num1.mod(num2).equals(BigInteger.ZERO) || num2.mod(num1).equals(BigInteger.ZERO)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
