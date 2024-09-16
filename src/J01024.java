import java.util.Scanner;

public class J01024 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (containsOnly012(n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean containsOnly012(long n) {
        while (n > 0) {
            long digit = n % 10;
            n = n / 10;
            if (digit != 0 && digit != 1 && digit != 2) {
                return false;
            }
        }
        return true;
    }
}
