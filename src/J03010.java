import java.util.*;

public class J03010 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Map<String, Integer> usernameMap = new HashMap<>();
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String input = sc.nextLine();
                String[] words = input.trim().split("\\s+");
                String email = generateEmail(words, usernameMap);
                System.out.println(email);
            }
        }
    }

    private static String generateEmail(String[] words, Map<String, Integer> usernameMap) {
        String givenName = words[words.length - 1];
        StringBuilder email = new StringBuilder(givenName.toLowerCase());

        for (int i = 0; i < words.length - 1; i++) {
            email.append(String.valueOf(words[i].charAt(0)).toLowerCase());
        }

        String username = email.toString();
        int count = usernameMap.getOrDefault(username, 0) + 1;
        usernameMap.put(username, count);

        if (count > 1) {
            email.append(count);
        }

        email.append("@ptit.edu.vn");
        return email.toString();
    }
}
