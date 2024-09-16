import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] sum = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    int num = sc.nextInt();
                    sum[i + 1] = sum[i] + num;
                }
                System.out.println(findBalancePoint(sum));
            }
        }
    }

    private static int findBalancePoint(int[] sum) {
        int totalSum = sum[sum.length - 1];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i - 1] == totalSum - sum[i]) {
                return i;
            }
        }
        return -1;
    }

}
