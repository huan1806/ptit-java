import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class J02007 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i = 1; i <= t; i++) {
                System.out.printf("Test %d:%n", i);
                LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
                int n = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    int num = sc.nextInt();
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.printf("%d xuat hien %d lan%n", entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
