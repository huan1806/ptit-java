import java.util.Scanner;

public class J02013 {
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
            for (int i = 1; i < n; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        swapped = true;
                    }
                }
                if (!swapped) {
                    if (i == 1) {
                        printArray(arr, 1);
                    }
                    break;
                }
                printArray(arr, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr, int step) {
        System.out.printf("Buoc %d:", step);
        for (int num : arr) {
            System.out.print(" " + num);
        }
        System.out.println();
    }
}
