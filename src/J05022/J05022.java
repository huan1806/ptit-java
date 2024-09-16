package J05022;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J05022 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Student> students = getStudents(sc);
            List<String> queries = getQueries(sc);
            Map<String, List<Student>> studentsGroupedByClass =
                    students.stream().collect(Collectors.groupingBy(Student::getClazz));
            for (String query : queries) {
                List<Student> studentsInQuery = studentsGroupedByClass.get(query);
                if (studentsInQuery != null) {
                    System.out.printf("DANH SACH SINH VIEN LOP %s:%n", query);
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
        sc.nextLine();
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }
        return queries;
    }
}
