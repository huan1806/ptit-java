import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J02009 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<int[]> details = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                details.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            details.sort(Comparator.comparingInt(detail -> detail[0]));
            int finishTime = 0;
            for (int[] detail : details) {
                if (finishTime < detail[0]) {
                    finishTime = detail[0] + detail[1];
                } else {
                    finishTime += detail[1];
                }
            }
            System.out.println(finishTime);
        }
    }
}
