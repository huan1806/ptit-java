package J05042;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05042 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Student> students = getStudents();
        students.sort(Comparator.comparing(Student::getCorrect).reversed()
                .thenComparing(Student::getTotalSubmit)
                .thenComparing(Student::getName));
        students.forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Student> students = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Student student = new Student(sc.nextLine(), sc.nextInt(), sc.nextInt());
                students.add(student);
            }
            return students;
        }
    }
}
