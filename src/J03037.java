import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J03037 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            char[] s = sc.nextLine().toCharArray();
            int count = 0;
            Map<Character, Integer> lastPositions = new HashMap<>();

            for (int i = 0; i < s.length; i++) {
                lastPositions.put(s[i], i);
            }

            for (int i = 0; i < s.length - 1; i++) {
                int lastPosition = lastPositions.get(s[i]);
                for (int j = i + 1; j < lastPosition; j++) {
                    if (lastPositions.get(s[j]) > lastPosition) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
