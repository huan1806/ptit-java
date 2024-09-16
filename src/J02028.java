import java.util.Scanner;

public class J02028 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long k = sc.nextLong();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                if (containsSubsetWhoseSumEqualsK(arr, k)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean containsSubsetWhoseSumEqualsK(int[] arr, long k) {
        int left = 0;
        int right = 0;
        long sum = arr[left];
        while (left < arr.length) {
            if (sum == k) {
                return true;
            }
            if (left == right || sum < k) {
                if (++right == arr.length) {
                    return false;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return false;
    }
}
