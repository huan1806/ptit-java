import java.util.Scanner;

public class JKT014 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                int[] rhythms = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                for (int i = 0; i < n; i++) {
                    rhythms[i] = i - find(arr[i], i - 1, arr, rhythms);
                }

                for (int i = 0; i < n; i++) {
                    System.out.print(rhythms[i] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int find(int val, int pos, int[] arr, int[] rhythms) {
        if (pos < 0) {
            return -1;
        }
        if (arr[pos] > val) {
            return pos;
        }
        return find(val, pos - rhythms[pos], arr, rhythms);
    }
}
