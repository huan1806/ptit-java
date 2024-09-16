package J05005;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class Helper {
    public static String standardizeDate(String date) {
        if ('/' == date.charAt(1)) {
            date = "0" + date;
        }
        if ('/' == date.charAt(4)) {
            date = date.substring(0, 3) + "0" + date.substring(3);
        }
        return date;
    }

    public static String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        return Arrays.stream(words).map(word ->
                word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
        ).collect(Collectors.joining(" "));
    }
}
