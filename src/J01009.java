import java.util.Scanner;

public class J01009 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long product = 1;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            product *= i;
            sum += product;
        }
        System.out.println(sum);
        sc.close();
    }
}
