import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J08015 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long k = sc.nextLong();
                Map<Long, Integer> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    long num = sc.nextLong();
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                long count = 0;
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    long value = entry.getValue();
                    if (2 * entry.getKey() == k) {
                        count += value * (value - 1);
                    } else if (map.containsKey(k - entry.getKey())) {
                        count += value * map.get(k - entry.getKey());
                    }
                }
                System.out.println(count / 2);
            }
        }
    }
}
