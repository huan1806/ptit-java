import java.util.Scanner;

public class J02103 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int testNum = sc.nextInt();
            for (int t = 1; t <= testNum; t++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[][] arr = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = sc.nextInt();
                    }
                }
                int[][] product = productOfMatrixAndItsTranspose(arr);
                System.out.printf("Test %d:%n", t);
                printMatrix(product);
            }
        }
    }

    private static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] productOfMatrixAndItsTranspose(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] product = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int k = 0; k < m; k++) {
                    temp += arr[i][k] * arr[j][k];
                }
                product[i][j] = temp;
            }
        }

        return product;
    }
}
