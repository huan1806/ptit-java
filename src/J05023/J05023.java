package J05023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J05023 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Student> students = getStudents(sc);
            List<String> queries = getQueries(sc);
            Map<String, List<Student>> studentsGroupedBySchoolYear =
                    students.stream().collect(Collectors.groupingBy(Student::getSchoolYear));
            for (String query : queries) {
                List<Student> studentsInQuery = studentsGroupedBySchoolYear.get(query.substring(2));
                System.out.printf("DANH SACH SINH VIEN KHOA %s:%n", query);
                if (studentsInQuery != null) {
                    studentsInQuery.forEach(System.out::println);
                }
            }
        }
    }

    private static List<Student> getStudents(Scanner sc) {
        int n = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine());
            students.add(student);
        }
        return students;
    }

    private static List<String> getQueries(Scanner sc) {
        int q = sc.nextInt();
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(sc.next());
        }
        return queries;
    }
}
