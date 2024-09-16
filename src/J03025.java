import java.util.Scanner;

public class J03025 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                if (transformableToPalindrome(s)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean transformableToPalindrome(String s) {
        int diffCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                diffCount++;
            }
        }
        return diffCount == 1 || (diffCount == 0 && s.length() % 2 != 0);
    }
}
