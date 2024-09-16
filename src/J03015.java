import java.math.BigInteger;
import java.util.Scanner;

public class J03015 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            BigInteger num1 = sc.nextBigInteger();
            BigInteger num2 = sc.nextBigInteger();
            System.out.println(num1.subtract(num2));
        }
    }
}
