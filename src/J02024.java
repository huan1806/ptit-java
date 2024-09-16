import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class J02024 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Integer[] arr = new Integer[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr);
                List<String> combinations = new ArrayList<>();
                generateCombination(arr.length, arr, 0, "", combinations);
                combinations.forEach(System.out::println);
            }
        }
    }

    private static void generateCombination(int end, Integer[] arr, int sum, String current,
                                            List<String> combinations) {
        if (sum % 2 == 1) {
            combinations.add(current);
        }
        for (int i = 0; i < end; i++) {
            generateCombination(i, arr, sum + arr[i], current + arr[i] + " ", combinations);
        }
    }
}
