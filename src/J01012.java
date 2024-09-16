import java.util.Scanner;

public class J01012 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0) {
            int n = sc.nextInt();
            System.out.println(countEvenDivisors(n));
        }
        sc.close();
    }

    private static int countEvenDivisors(int num) {
        if (num % 2 != 0) {
            return 0;
        }
        int ret = 0;
        while (num % 2 == 0) {
            num /= 2;
            ret++;
        }
        for (int i = 3; i * i <= num; i++) {
            int count = 0;
            while (num % i == 0) {
                num /= i;
                count++;
            }
            ret *= (count + 1);
        }
        if (num > 1) {
            ret *= 2;
        }
        return ret;
    }
}