import java.util.Scanner;

public class J03005 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String input = sc.nextLine();
                String[] words = input.trim().split("\\s+");
                if (words.length == 0) {
                    return;
                }
                String familyName = words[0];
                for (int i = 1; i < words.length - 1; i++) {
                    System.out.print(capitalize(words[i]) + " ");
                }
                if (words.length > 1) {
                    System.out.print(capitalize(words[words.length - 1]));
                }
                System.out.println(", " + familyName.toUpperCase());
            }
        }
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
