import java.util.Scanner;

public class J01013 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long sum = 0;
            long[] sumArray = getSumOfFactorsArray();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                sum += sumArray[num];
            }
            System.out.println(sum);
        }
    }

    private static long[] getSumOfFactorsArray() {
        int max = 2_000_001;
        long[] sumOfFactors = new long[max];
        for (int i = 2; i < max; i++) {
            if (sumOfFactors[i] == 0) {
                sumOfFactors[i] = i;
                for (int j = 2 * i; j < max; j += i) {
                    int temp = j;
                    while (temp % i == 0) {
                        temp /= i;
                        sumOfFactors[j] += i;
                    }
                }
            }
        }
        return sumOfFactors;
    }
}
