import java.util.Scanner;
import java.util.Stack;

public class J03027 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("Empty String");
            } else {
                stack.forEach(System.out::print);
            }
        }
    }
}
