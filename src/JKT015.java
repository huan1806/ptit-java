import java.util.Scanner;
import java.util.Stack;

public class JKT015 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '-':
                        if (!left.empty()) {
                            left.pop();
                        }
                        break;
                    case '<':
                        if (!left.empty()) {
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.empty()) {
                            left.push(right.pop());
                        }
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }
            left.forEach(System.out::print);
            while (!right.empty()) {
                System.out.print(right.pop());
            }
        }
    }
}
