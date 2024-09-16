import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class J08021 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String input = sc.nextLine();
                System.out.println(findMaxValidBracketsLength(input));
            }

        }
    }

    private static int findMaxValidBracketsLength(String s) {
        int max = 0;
        int[] count = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()){
                int prev = stack.pop();
                count[i + 1] = count[prev] + i  - prev + 1;
                max = Math.max(max, count[i + 1]);
            }
        }

        return max;
    }
}
