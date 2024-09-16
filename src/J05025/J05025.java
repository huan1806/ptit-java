package J05025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05025 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Lecturer> lecturers = getLecturers();
        lecturers.sort(Comparator.comparing(Lecturer::getGivenName).thenComparing(Lecturer::getId));
        lecturers.forEach(System.out::println);
    }

    private static List<Lecturer> getLecturers() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Lecturer> lecturers = new ArrayList<>();

            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                Lecturer lecturer = new Lecturer(sc.nextLine(), sc.nextLine());
                lecturers.add(lecturer);
            }

            return lecturers;
        }
    }
}
