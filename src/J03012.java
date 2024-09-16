import java.math.BigInteger;
import java.util.Scanner;

public class J03012 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                BigInteger x = sc.nextBigInteger();
                BigInteger y = sc.nextBigInteger();
                System.out.println(x.add(y));
            }
        }
    }
}
