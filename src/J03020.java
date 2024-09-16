import java.util.LinkedHashMap;
import java.util.Scanner;

public class J03020 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int max = 0;
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.length() >= max && isAPalindrome(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    max = word.length();
                }
            }
            for (String word : map.keySet()) {
                if (word.length() == max) {
                    System.out.println(word + " " + map.get(word));
                }
            }
        }
    }

    private static boolean isAPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }
}
