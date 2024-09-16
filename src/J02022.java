import java.util.Scanner;
import java.util.Stack;

public class J02022 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                generate(n, new Stack<>());
                System.out.println();
            }
        }
    }

    private static void generate(int n, Stack<Integer> stack) {
        if (stack.size() == n) {
            stack.forEach(System.out::print);
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!stack.isEmpty() && (Math.abs(stack.peek() - i) == 1 || stack.contains(i))) {
                continue;
            }
            stack.push(i);
            generate(n, stack);
            stack.pop();
        }
    }
}
