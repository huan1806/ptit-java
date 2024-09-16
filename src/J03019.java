import java.util.Scanner;

public class J03019 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            char[] charArray = s.toCharArray();
            StringBuilder ret = new StringBuilder();
            char prev = charArray[charArray.length - 1];
            for (int i = charArray.length - 1; i >= 0; i--) {
                if (charArray[i] >= prev) {
                    ret.insert(0, charArray[i]);
                    prev = charArray[i];
                }
            }
            System.out.println(ret);
        }
    }
}
