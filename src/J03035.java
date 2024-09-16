import java.util.Scanner;

public class J03035 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String a = sc.next();
                String b = sc.next();
                System.out.println(countLargerNumbers(a, b, 0));
            }
        }
    }

    private static long countLargerNumbers(String num1, String num2, int idx) {
        if (idx == num1.length()) {
            return 0;
        }

        char d1 = num1.charAt(idx);
        char d2 = num2.charAt(idx);

        if (d1 == '?') {
            int missingLeft = countMissingLeft(num1, idx + 1);
            return (long) Math.pow(10, missingLeft) * (9 - (d2 - '0')) + countLargerNumbers(num1, num2, idx + 1);
        }

        if (d1 > d2) {
            int missingLeft = countMissingLeft(num1, idx + 1);
            return (long) Math.pow(10, missingLeft);
        }

        if (d1 == d2) {
            return countLargerNumbers(num1, num2, idx + 1);
        }

        return 0;
    }

    private static int countMissingLeft(String num, int start) {
        int count = 0;
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }
}
