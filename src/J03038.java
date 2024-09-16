import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03038 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            System.out.println(set.size());
        }
    }
}
