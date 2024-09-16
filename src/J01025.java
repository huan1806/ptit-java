import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int[] x = new int[4];
            int[] y = new int[4];
            for (int i = 0; i < 4; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            int minX = findMinLength(x);
            int minY = findMinLength(y);
            int minLen = Math.max(minX, minY);
            System.out.println(minLen * minLen);
        }
    }

    private static int findMinLength(int[] k) {
        return Math.max(Math.max(k[1] - k[0], k[3] - k[2]), Math.max(Math.abs(k[2] - k[1]), Math.abs(k[3] - k[0])));
    }
}
