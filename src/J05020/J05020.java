package J05020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05020 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
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
            students.sort(Comparator.comparing(Student::getClazz).thenComparing(Student::getId));
            students.forEach(System.out::println);
        }
    }
}
