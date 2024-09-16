import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class J07076 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(new File("MATRIX.in"))) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int i = sc.nextInt();
                int[][] arr = new int[m][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        arr[k][j] = sc.nextInt();
                    }
                }
                Arrays.sort(arr[i - 1]);
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        System.out.print(arr[k][j] + " ");
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
