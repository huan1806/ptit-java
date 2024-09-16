import java.util.Scanner;

public class J02036 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int[] arr = readArray(sc);
                System.out.printf("%d ", arr[0]);
                for (int i = 1; i < arr.length; i++) {
                    System.out.printf("%d ", lcm(arr[i], arr[i - 1]));
                }
                System.out.printf("%d%n", arr[arr.length - 1]);
            }
        }
    }

    private static int[] readArray(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
