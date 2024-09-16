import java.util.Scanner;

public class J01026 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (isPerfectSquareNumber(n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean isPerfectSquareNumber(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
