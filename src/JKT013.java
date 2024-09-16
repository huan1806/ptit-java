import java.util.*;

public class JKT013 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<String> combinations = getCombinations();
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int count = (int) Math.pow(2, n + 1) - 2;
                System.out.println(count);
                for (int i = count - 1; i >= 0; i--) {
                    System.out.print(combinations.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    private static List<String> getCombinations() {
        List<String> combinations = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("6");
        queue.add("8");
        while (queue.peek().length() < 15) {
            String value = queue.remove();
            combinations.add(value);
            queue.add(value + "6");
            queue.add(value + "8");
        }
        return combinations;
    }
}
