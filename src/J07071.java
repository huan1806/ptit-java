import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07071 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<String> names = new ArrayList<>();
        List<String> acronyms = new ArrayList<>();
        readData(names, acronyms);
        for (String acronym : acronyms) {
            List<String> matches = new ArrayList<>();
            String rgx = "^" + acronym.replace("*", "").replace(".", "[a-zA-Z]+ ") + "[a-zA-Z]+$";
            for (String name : names) {
                if (name.matches(rgx)) {
                    matches.add(name);
                }
            }
            sort(matches);
            matches.forEach(System.out::println);
        }
    }

    private static void readData(List<String> names, List<String> acronyms) {
        try (Scanner sc = new Scanner(new File("DANHSACH.in"))) {
            readList(sc, names);
            readList(sc, acronyms);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readList(Scanner sc, List<String> list) {
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
    }

    private static void sort(List<String> matches) {
        matches.sort((s1, s2) -> {
            String[] frags1 = s1.split("\\s+");
            String[] frags2 = s2.split("\\s+");
            if (!frags1[frags1.length - 1].equals(frags2[frags2.length - 1])) {
                return frags1[frags1.length - 1].compareTo(frags2[frags2.length - 1]);
            }
            return frags1[0].compareTo(frags2[0]);
        });
    }
}
