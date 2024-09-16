import java.util.Scanner;

public class J02034 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] count = new int[201];
            for (int i = 0; i < n - 1; i++) {
                count[sc.nextInt()]++;
            }
            int lastNum = sc.nextInt();
            if (lastNum == n) {
                System.out.println("Excellent!");
            } else {
                for (int i = 1; i < lastNum; i++) {
                    if (count[i] == 0) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
