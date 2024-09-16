import java.util.Scanner;

public class J02004 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n / 2];
                for (int i = 0; i < n / 2; i++) {
                    arr[i] = sc.nextInt();
                }
                if (n % 2 != 0) {
                    sc.nextInt();
                }
                boolean isSymmetric = true;
                for (int i = 0; i < n / 2; i++) {
                    int num = sc.nextInt();
                    if (num != arr[n / 2 - i - 1]) {
                        isSymmetric = false;
                    }
                }
                if (isSymmetric) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
