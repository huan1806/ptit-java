package J05005;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05005 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Student student = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
                students.add(student);
            }
            students.sort(Comparator.comparing(Student::getGpa).reversed());
            students.forEach(System.out::println);
        }
    }
}
