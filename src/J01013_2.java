import java.util.Scanner;

public class J01013_2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        long[] sumArray = getSumOfFactorsArray();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += sumArray[num];
        }
        System.out.println(sum);
        sc.close();
    }

    private static long[] getSumOfFactorsArray() {
        int max = 2_000_001;
        long[] sumOfFactors = new long[max];
        for (int i = 0; i < max; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sumOfFactors[i] = sumOfFactors[j] + sumOfFactors[i / j];
                    break;
                }
            }
            if (sumOfFactors[i] == 0) {
                sumOfFactors[i] = i;
            }
        }
        return sumOfFactors;
    }
}
