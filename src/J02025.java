import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class J02025 {
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
                boolean[] primes = getPrimesArr();
                generateCombination(arr.length, arr, primes, 0, "", combinations);
                combinations.forEach(System.out::println);
            }
        }
    }

    private static void generateCombination(int end, Integer[] arr, boolean[] primes, int sum, String current,
                                            List<String> combinations) {
        if (primes[sum]) {
            combinations.add(current);
        }
        for (int i = 0; i < end; i++) {
            generateCombination(i, arr, primes, sum + arr[i], current + arr[i] + " ", combinations);
        }
    }

    private static boolean[] getPrimesArr() {
        boolean[] primes = new boolean[1000];
        Arrays.fill(primes, 2, 999, true);
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2 * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
