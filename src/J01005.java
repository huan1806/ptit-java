import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int testNum = sc.nextInt();
            while (testNum-- > 0) {
                int n = sc.nextInt();
                int h = sc.nextInt();
                for (int i = 1; i < n; i++) {
                    double x = h * Math.sqrt((double) i / n);
                    System.out.printf("%.6f ", x);
                }
                System.out.println();
            }
        }
    }
}