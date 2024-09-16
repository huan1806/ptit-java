import java.util.Scanner;

public class J03024 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                String result = test(s);
                System.out.println(result);
            }
        }
    }

    private static String test(String s) {
        if (s.charAt(0) == '0') {
            return "INVALID";
        }
        int countEvens = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "INVALID";
            }
            if ((c - '0') % 2 == 0) {
                countEvens++;
            }
        }
        if (s.length() % 2 == 0) {
            return 2 * countEvens > s.length() ? "YES" : "NO";
        }
        return 2 * countEvens < s.length() ? "YES" : "NO";
    }
}
