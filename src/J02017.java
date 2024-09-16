import java.util.Scanner;
import java.util.Stack;

public class J02017 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            stack.add(sc.nextInt());
            for (int i = 1; i < n; i++) {
                int num = sc.nextInt();
                if (stack.isEmpty() || (stack.peek() + num) % 2 != 0) {
                    stack.push(num);
                } else {
                    stack.pop();
                }
            }
            System.out.println(stack.size());
        }
    }
}