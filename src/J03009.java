import java.util.*;

public class J03009 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String s1 = sc.nextLine();
                String s2 = sc.nextLine();
                Set<String> words1 = getWordsSet(s1);
                Set<String> words2 = getWordsSet(s2);
                words1.removeAll(words2);
                words1.stream().sorted().forEach(word -> System.out.print(word + " "));
                System.out.println();
            }
        }
    }

    private static Set<String> getWordsSet(String s) {
        return new HashSet<>(Arrays.asList(s.trim().split("\\s+")));
    }
}
