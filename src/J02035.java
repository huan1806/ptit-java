import java.util.Scanner;

public class J02035 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long pre = 0;
                int res = 0;
                for (int i = 0; i < n; i++) {
                    long num = sc.nextLong();
                    if (num < pre) {
                        res = i;
                    }
                    pre = num;
                }
                System.out.println(res);
            }
        }
    }
}
