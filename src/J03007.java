import java.util.Scanner;

public class J03007 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String num = sc.nextLine();
                if (isBeautifulNumber2(num)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean isBeautifulNumber2(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        if (arr[0] != '8' || arr[len - 1] != '8') {
            return false;
        }
        int sumOfDigits = 8;
        for (int i = 1; i < len / 2; i++) {
            char digit = arr[i];
            if (digit != arr[len - i - 1]) {
                return false;
            }
            sumOfDigits += digit - '0';
        }
        sumOfDigits *= 2;
        if (len % 2 != 0) {
            sumOfDigits += arr[len / 2] - '0';
        }
        return sumOfDigits % 10 == 0;
    }
}
