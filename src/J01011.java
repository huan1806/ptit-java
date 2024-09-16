import java.util.Scanner;

public class J01011 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("%d %d%n", lcm(a, b), gcd(a, b));
        }
        sc.close();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }
}