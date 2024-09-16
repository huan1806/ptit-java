import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07021 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("DATA.in"))) {
            String input = null;
            while (!"END".equals(input = sc.nextLine())) {
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
