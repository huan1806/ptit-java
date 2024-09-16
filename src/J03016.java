import java.math.BigInteger;
import java.util.Scanner;

public class J03016 {
    private static final BigInteger ELEVEN = BigInteger.valueOf(11);

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                BigInteger num = sc.nextBigInteger();
                if (num.mod(ELEVEN).equals(BigInteger.ZERO)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}
