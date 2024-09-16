import java.util.Scanner;

public class J03040 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String licensePlate = sc.next();
                if (isBeautiful(licensePlate)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean isBeautiful(String lp) {
        char[] digits = new char[]{lp.charAt(5), lp.charAt(6), lp.charAt(7), lp.charAt(9), lp.charAt(10)};

        return isStrictlyAscending(digits) || hasPatternXXXYY(digits) || containsOnly6And8(digits);
    }

    private static boolean isStrictlyAscending(char[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] <= digits[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasPatternXXXYY(char[] digits) {
        return digits[0] == digits[1] && digits[1] == digits[2] && digits[3] == digits[4];
    }

    private static boolean containsOnly6And8(char[] digits) {
        for (char c : digits) {
            if (c != '6' && c != '8') {
                return false;
            }
        }
        return true;
    }
}
