import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03031 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int k = sc.nextInt();
                if (k >= 26 - countDistinctAlphabets(s)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int countDistinctAlphabets(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                set.add(c);
            }
        }
        return set.size();
    }
}
