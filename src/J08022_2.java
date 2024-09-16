import java.util.Scanner;
import java.util.Stack;

public class J08022_2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                int[] result = new int[n];
                Stack<Integer> stack = new Stack<>();

                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                for (int i = n - 1; i >= 0; i--) {
                    while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        result[i] = stack.peek();
                    } else {
                        result[i] = -1;
                    }
                    stack.push(arr[i]);
                }

                for (int value : result) {
                    System.out.print(value + " ");
                }

                System.out.println();
            }
        }
    }

    private static int findRightNearestLarger(int[] arr, int x) {
        for (int i = x + 1; i < arr.length; i++) {
            if (arr[i] > arr[x]) {
                return arr[i];
            }
        }
        return -1;
    }
}
