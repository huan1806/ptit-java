package J05018;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05018 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Student> students = readList();
        students.sort(Comparator.comparing(Student::getGpa).reversed());
        students.forEach(System.out::println);
    }

    private static List<Student> readList() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                String name = sc.nextLine();
                double[] scores = new double[10];
                for (int j = 0; j < 10; j++) {
                    scores[j] = sc.nextDouble();
                }
                Student student = new Student(name, scores);
                list.add(student);
            }
            return list;
        }
    }
}
