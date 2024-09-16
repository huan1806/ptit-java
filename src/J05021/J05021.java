package J05021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05021 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Student> students = new ArrayList<>();
            while (sc.hasNextLine()) {
                Student student = new Student(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine());
                students.add(student);
            }
            students.sort(Comparator.comparing(Student::getId));
            students.forEach(System.out::println);
        }
    }
}
