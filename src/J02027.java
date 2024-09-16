import java.util.Arrays;
import java.util.Scanner;

public class J02027 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr);
                System.out.println(countPairsWhoseDiffLessThanK(arr, k));
            }
        }
    }

    private static long countPairsWhoseDiffLessThanK(int[] arr, int k) {
        long count = 0;
        int pre = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            count += pre - i;
            int j = pre + 1;
            while (j < arr.length && arr[j] - arr[i] < k) {
                count++;
                pre = j++;
            }
        }
        return count;
    }
}
