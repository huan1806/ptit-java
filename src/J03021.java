import java.util.Scanner;

public class J03021 {

    private static final String[] GROUPS = new String[]{
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                StringBuilder num = new StringBuilder();
                for (char c : s.toCharArray()) {
                    int toNum = letterToNumber(c);
                    if (toNum != -1) {
                        num.append(letterToNumber(c));
                    }
                }
                if (isPalindrome(num.toString())) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int letterToNumber(char c) {
        String letter = Character.toString(c).toLowerCase();
        for (int i = 0; i < GROUPS.length; i++) {
            if (GROUPS[i].contains(letter)) {
                return i + 2;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
