import java.util.Scanner;

public class J08012 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] count = new int[n + 1];
            for (int i = 0; i < 2 * n - 2; i++) {
                count[sc.nextInt()]++;
            }
            if (isStarGraph(count)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isStarGraph(int[] count) {
        int n = count.length - 1;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return true;
            }
        }
        return false;
    }
}
