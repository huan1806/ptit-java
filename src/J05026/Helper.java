package J05026;

import java.util.Arrays;

public final class Helper {
    public static String getAbbreviation(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String[] words = s.split(" ");
        return Arrays.stream(words).map(word -> word.substring(0, 1).toUpperCase())
                .reduce("", String::concat);
    }
}
