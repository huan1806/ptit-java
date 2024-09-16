import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class J08020 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String input = sc.nextLine();
                if (isValid(input)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        final Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (bracketMap.containsValue(c)) {
                stack.push(c);
            } else if (bracketMap.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
