import java.util.Scanner;

public class J03030 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            int length = s.length();
            int[] dpA = new int[length + 1];
            int[] dpB = new int[length + 1];
            for (int i = 0; i < length; i++) {
                int temp = Math.min(dpA[i] + 1, dpB[i] + 1);
                if (s.charAt(i) == 'A') {
                    dpA[i + 1] = Math.min(dpA[i], dpB[i] + 1);
                    dpB[i + 1] = temp;
                } else {
                    dpA[i + 1] = temp;
                    dpB[i + 1] = Math.min(dpA[i] + 1, dpB[i]);
                }
            }
            System.out.println(dpA[length]);
        }
    }
}
