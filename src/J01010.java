import java.util.Scanner;

public class J01010 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while (testNum-- > 0) {
            String n = sc.next();
            System.out.println(cutInHalf(n));
        }
        sc.close();
    }

    private static String cutInHalf(String n) {
        StringBuilder sb = new StringBuilder();
        for (char digit : n.toCharArray()) {
            switch (digit) {
                case '0':
                case '8':
                case '9':
                    if (sb.length() > 0) {
                        sb.append(0);
                    }
                    break;
                case '1':
                    sb.append(1);
                    break;
                default:
                    return "INVALID";
            }
        }
        return sb.length() == 0 ? "INVALID" : sb.toString();
    }
}