import java.util.Scanner;

public class J03004 {
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
                for (String word : words) {
                    System.out.print(capitalize(word) + " ");
                }
                System.out.println();
            }
        }
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
