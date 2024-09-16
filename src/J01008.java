import java.util.Scanner;

public class J01008 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 1; i <= testNum; i++) {
            System.out.printf("Test %d: ", i);
            int n = sc.nextInt();
            for (int j = 2; j * j <= n; j++) {
                int count = 0;
                while (n % j == 0) {
                    n /= j;
                    count++;
                }
                if (count > 0) {
                    System.out.printf(" %d(%d)", j, count);
                }
            }
            if (n > 1) {
                System.out.printf(" %d(%d)", n, 1);
            }
            System.out.println();
        }
        sc.close();
    }
}