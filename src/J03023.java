import java.util.Scanner;

public class J03023 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String romanNum = sc.next();
                System.out.println(convertToInteger(romanNum));
            }
        }
    }

    public static int convertToInteger(String s) {
        int preVal = toInt(s.charAt(s.length() - 1));
        int value = preVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            int currVal = toInt(s.charAt(i));
            if (currVal < preVal) {
                value -= currVal;
            } else {
                value += currVal;
            }
            preVal = currVal;
        }
        return value;
    }

    public static int toInt(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
