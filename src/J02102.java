import java.util.Arrays;
import java.util.Scanner;

public class J02102 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int[] nums = readInput();
        Arrays.sort(nums);
        int[][] matrix = generateClockwiseMatrix(nums);
        printMatrix(matrix);
    }

    private static int[] readInput() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n * n];
            for (int i = 0; i < n * n; i++) {
                arr[i] = sc.nextInt();
            }
            return arr;
        }
    }

    private static int[][] generateClockwiseMatrix(int[] nums) {
        int n = (int) Math.sqrt(nums.length);
        int[][] matrix = new int[n][n];
        int i = 0;
        int k = 0;
        while (i < n / 2) {
            for (int j = i; j < n - i - 1; j++) {
                matrix[i][j] = nums[k++];
            }
            for (int j = i; j < n - i - 1; j++) {
                matrix[j][n - i - 1] = nums[k++];
            }
            for (int j = n - i - 1; j > i; j--) {
                matrix[n - i - 1][j] = nums[k++];
            }
            for (int j = n - i - 1; j > i; j--) {
                matrix[j][i] = nums[k++];
            }
            i++;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = nums[k];
        }
        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
