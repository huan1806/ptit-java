package J05027;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05027 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Lecturer> lecturers = getLecturers(sc);
            List<String> queries = getQueries(sc);
            queries.forEach(query -> {
                System.out.printf("DANH SACH GIANG VIEN THEO TU KHOA %s:%n", query);
                lecturers.forEach(lecturer -> {
                    String name = lecturer.getName();
                    if (name.toLowerCase().contains(query.toLowerCase())) {
                        System.out.println(lecturer);
                    }
                });
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
