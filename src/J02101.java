import java.util.Scanner;

public class J02101 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[j] = sc.nextInt();
                    }
                    printRow(i, arr);
                }
                System.out.println();
            }
        }
    }

    private static void printRow(int row, int[] arr) {
        if (row % 2 == 0) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
