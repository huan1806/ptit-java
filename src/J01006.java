import java.util.Scanner;

public class J01006 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        long[] fibonacciList = getFibonacciList();
        try (Scanner sc = new Scanner(System.in)) {
            int testNum = sc.nextInt();
            while (testNum-- > 0) {
                int n = sc.nextInt();
                System.out.println(fibonacciList[n]);
            }
        }
    }

    private static long[] getFibonacciList() {
        long[] fibonacciList = new long[93];
        fibonacciList[1] = 1;
        for (int i = 2; i < 93; i++) {
            fibonacciList[i] = fibonacciList[i - 1] + fibonacciList[i - 2];
        }
        return fibonacciList;
    }
}