import java.util.Scanner;

public class J02005 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] c = new int[1000];
            count(sc, n + m, c);
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void count(Scanner sc, int size, int[] c) {
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt();
            c[num]++;
        }
    }
}
