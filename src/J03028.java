import java.util.Scanner;

public class J03028 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                StringBuilder ret = new StringBuilder();
                int sum = 0;
                char[] arr = s.toCharArray();
                for (char ch : arr) {
                    sum += ch - 'A';
                }
                for (int i = 0; i < s.length() / 2; i++) {
                    int val = s.charAt(i) - 2 * 'A' + sum + s.charAt(s.length() / 2 + i);
                    ret.append(toChar(val));
                }
                System.out.println(ret);
            }
        }
    }

    private static char toChar(int n) {
        n %= 26;
        return (char) ('A' + n);
    }
}
