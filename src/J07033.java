import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07033 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("SINHVIEN.in");
        try (Scanner sc = new Scanner(file)) {
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
            students.sort(Comparator.comparing(s -> s.id));
            students.forEach(System.out::println);
        }
    }

    private static class Student {
        private String id;
        private String fullName;
        private String clazz;
        private String email;

        public Student(String id, String fullName, String clazz, String email) {
            this.id = id;
            this.fullName = formatName(fullName);
            this.clazz = clazz;
            this.email = email;
        }

        private static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(Student::capitalize).collect(Collectors.joining(" "));
        }

        private static String capitalize(String s) {
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s", id, fullName, clazz, email);
        }
    }
}
