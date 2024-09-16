import java.util.Scanner;

public class J02105 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.printf("List(%d) =", i);
                for (int j = 1; j <= n; j++) {
                    int val = sc.nextInt();
                    if (val == 1) {
                        System.out.print(" " + j);
                    }
                }
                System.out.println();
            }
        }
    }
}
