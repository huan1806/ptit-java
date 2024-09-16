import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07081 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Student> students = getStudents();
        students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getCode));
        students.forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        try (Scanner sc = new Scanner(new File("SINHVIEN.in"))) {
            int n = Integer.parseInt(sc.nextLine().trim());
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Student student = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
                students.add(student);
            }
            return students;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Student {
        private String code;
        private Name name;
        private String phoneNumber;
        private String email;

        public Student(String code, String name, String phoneNumber, String email) {
            this.code = code;
            this.name = new Name(name);
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getCode() {
            return code;
        }

        public Name getName() {
            return name;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + phoneNumber + " " + email;
        }
    }

    private static class Name implements Comparable<Name> {

        private final String value;

        public Name(String value) {
            this.value = formatName(value);
        }

        public String[] splitLastName() {
            int l = value.lastIndexOf(" ");
            return new String[]{value.substring(0, l), value.substring(l + 1)};
        }

        @Override
        public int compareTo(Name n2) {
            String[] frags1 = splitLastName();
            String[] frags2 = n2.splitLastName();
            if (!frags1[1].equals(frags2[1])) {
                return frags1[1].compareTo(frags2[1]);
            }
            return frags1[0].compareTo(frags2[0]);
        }

        @Override
        public String toString() {
            return value;
        }

        private String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }
    }
}
