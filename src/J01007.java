import java.util.Scanner;

public class J01007 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        long[] fibonacciList = getFibonacciList();
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0) {
            long n = sc.nextLong();
            boolean isFibonacci = false;
            for (long f : fibonacciList) {
                if (f == n) {
                    isFibonacci = true;
                    break;
                }
            }
            if (isFibonacci) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
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