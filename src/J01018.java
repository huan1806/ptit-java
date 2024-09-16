import java.util.Scanner;

public class J01018 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (isSpecialNumber(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean isSpecialNumber(long n) {
        int previousDigit = (int) (n % 10);
        n /= 10;
        int sumOfDigits = previousDigit;
        while (n > 0) {
            int currentDigit = (int) (n % 10);
            n /= 10;
            if (Math.abs(currentDigit - previousDigit) != 2) {
                return false;
            }
            previousDigit = currentDigit;
            sumOfDigits += currentDigit;
        }
        return sumOfDigits % 10 == 0;
    }
}