import java.util.Arrays;
import java.util.Scanner;

public class J05033 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] secondsArr = new int[n];
        for (int i = 0; i < n; i++) {
            secondsArr[i] = (sc.nextInt() * 60 + sc.nextInt()) * 60 + sc.nextInt();
        }
        sc.close();
        System.gc();
        Arrays.sort(secondsArr);
        for (int s : secondsArr) {
            System.out.printf("%d %d %d%n", s / 3600, (s % 3600) / 60, s % 60);
        }
        System.gc();
    }
}