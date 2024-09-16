import java.util.Scanner;

public class J08022 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(findRightNearestLarger(arr, i) + " ");
                }
                System.out.println();
            }
        }
    }

    private static int findRightNearestLarger(int[] arr, int x) {
        for (int i = x + 1; i < arr.length; i++) {
            if (arr[i] > arr[x]) {
                return arr[i];
            }
        }
        return -1;
    }
}
