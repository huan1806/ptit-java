import java.util.Scanner;

public class J02104 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = sc.nextInt();
                    if (val == 1 && j > i) {
                        System.out.printf("(%d,%d)%n", i + 1, j + 1);
                    }
                }
            }
        }
    }
}
