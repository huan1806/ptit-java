import java.math.BigInteger;
import java.util.Scanner;

public class J03013 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String ret = getDiff(sc.nextBigInteger(), sc.nextBigInteger());
                System.out.println(ret);
            }
        }
    }

    private static String getDiff(BigInteger num1, BigInteger num2) {
        BigInteger diff = num1.subtract(num2).abs();
        int numberOf0 = Math.max(num1.toString().length(), num2.toString().length()) - diff.toString().length();
        return getLeading0(numberOf0) + diff;
    }

    private static String getLeading0(int size) {
        return new String(new char[size]).replace("\0", "0");
    }
}
