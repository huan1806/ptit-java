import java.util.Scanner;

public class J02011 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int val = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > val) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = val;
                printArray(arr, i);
            }
        }
    }

    private static void printArray(int[] arr, int i) {
        System.out.printf("Buoc %d:", i);
        for (int j = 0; j <= i; j++) {
            System.out.print(" " + arr[j]);
        }
        System.out.println();
    }
}
