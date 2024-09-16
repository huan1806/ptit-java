package J05026;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J05026 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Lecturer> lecturers = getLecturers(sc);
            List<String> queries = getQueries(sc);
            Map<String, List<Lecturer>> lecturersGroupedByDepartment =
                    lecturers.stream().collect(Collectors.groupingBy(Lecturer::getDepartment));

            queries.forEach(query -> {
                System.out.printf("DANH SACH GIANG VIEN BO MON %s:%n", Helper.getAbbreviation(query));
                List<Lecturer> lecturersInQuery = lecturersGroupedByDepartment.get(query);
                if (lecturersInQuery != null) {
                    lecturersInQuery.forEach(System.out::println);
                }
            });
        }
    }

    private static List<Lecturer> getLecturers(Scanner sc) {
        List<Lecturer> lecturers = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            Lecturer lecturer = new Lecturer(sc.nextLine(), sc.nextLine());
            lecturers.add(lecturer);
        }

        return lecturers;
    }

    private static List<String> getQueries(Scanner sc) {
        int q = sc.nextInt();
        sc.nextLine();
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }
        return queries;
    }
}
