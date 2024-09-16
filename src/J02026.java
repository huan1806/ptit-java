import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class J02026 {
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
                List<String> combinations = new ArrayList<>();
                generateCombination(0, 0, k, arr, "", combinations);
                combinations.forEach(System.out::println);
            }
        }
    }

    private static void generateCombination(int start, int count, int k, int[] arr, String current,
                                            List<String> combinations) {
        if (count == k) {
            combinations.add(current);
        }
        for (int i = start; i < arr.length; i++) {
            generateCombination(i + 1, count + 1, k, arr, current + arr[i] + " ", combinations);
        }
    }
}
