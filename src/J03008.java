import java.util.Scanner;

public class J03008 {

    private static final String PRIME_DIGITS = "2357";
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String num = sc.nextLine();
                if (isBeautifulNumber3(num)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean isBeautifulNumber3(String num) {
        char[] arr = num.toCharArray();
        for (int i = 0; i < (arr.length + 1) / 2; i++) {
            char digit = arr[i];
            if (PRIME_DIGITS.indexOf(digit) < 0 || digit != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
