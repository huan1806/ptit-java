import java.util.Scanner;

public class J08024 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                System.out.println(findX(n));
            }
        }
    }

    private static int findX(int n) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int v = 9 * Integer.parseInt(Integer.toBinaryString(i));
            if (v % n == 0) {
                return v;
            }
        }
        return -1;
    }
}
