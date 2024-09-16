import java.util.Scanner;

public class J03022 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] sentences = line.trim().split("[.?!]");
                for (String sentence : sentences) {
                    if (!sentence.isEmpty()) {
                        sentence = sentence.trim().replaceAll("\\s+", " ");
                        System.out.println(capitalize(sentence));
                    }
                }
            }
        }
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
