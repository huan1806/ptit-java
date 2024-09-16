import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class J07003 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("DATA.in");
        try (Scanner sc = new Scanner(file)) {
            BigInteger num = sc.nextBigInteger();
            BigInteger ten = new BigInteger("9");
            while (num.compareTo(ten) > 0) {
                String numStr = num.toString();
                int n = numStr.length();
                BigInteger firstPart = new BigInteger(numStr.substring(0, n / 2));
                BigInteger secondPart = new BigInteger(numStr.substring(n / 2));
                num = firstPart.add(secondPart);
                System.out.println(num);
            }
        }
    }
}
