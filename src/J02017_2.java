import java.util.Scanner;
import java.util.Stack;

public class J02017_2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int size = 1;
            arr[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                int num = sc.nextInt();
                if (size == 0 || (num + arr[size - 1]) % 2 != 0) {
                    arr[size++] = num;
                } else {
                    size--;
                }
            }
            System.out.println(size);
        }
    }
}