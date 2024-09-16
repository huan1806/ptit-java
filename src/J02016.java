import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J02016 {
    public static void main(String[] args) {
        solve();

    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Set<Long> squares = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    long num = sc.nextLong();
                    squares.add(num * num);
                }
                if (containsAtLeastOnePythagoreanTriplet(squares)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean containsAtLeastOnePythagoreanTriplet(Set<Long> set) {
        Long[] squares = new Long[set.size()];
        squares = set.toArray(squares);
        for (int i = 0; i < squares.length - 1; i++) {
            for (int j = i + 1; j < squares.length; j++) {
                if (set.contains(squares[i] + squares[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
