import java.math.BigInteger;
import java.util.Scanner;

public class J03014 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            BigInteger x = sc.nextBigInteger();
            BigInteger y = sc.nextBigInteger();
            System.out.println(x.add(y));
        }
    }
}
