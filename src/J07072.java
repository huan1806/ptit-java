import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07072 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(new File("DANHSACH.in"))) {
            List<Name> names = new ArrayList<>();
            while (sc.hasNextLine()) {
                names.add(new Name(sc.nextLine()));
            }
            Collections.sort(names);
            names.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Name implements Comparable<Name> {

        private final String value;

        public Name(String value) {
            this.value = formatName(value);
        }

        public String[] splitLastName() {
            int l = value.lastIndexOf(" ");
            return new String[]{value.substring(0, l), value.substring(l + 1)};
        }

        @Override
        public int compareTo(Name n2) {
            String[] frags1 = splitLastName();
            String[] frags2 = n2.splitLastName();
            if (!frags1[1].equals(frags2[1])) {
                return frags1[1].compareTo(frags2[1]);
            }
            return frags1[0].compareTo(frags2[0]);
        }

        @Override
        public String toString() {
            return value;
        }

        private String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }
    }
}
