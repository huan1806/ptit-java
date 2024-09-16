import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07058 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Subject> subjects = getSubjects();
        subjects.sort(Comparator.comparing(Subject::getCode));
        subjects.forEach(System.out::println);
    }

    private static List<Subject> getSubjects() {
        try (Scanner sc = new Scanner(new File("MONHOC.in"))) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Subject> subjects = new ArrayList<Subject>();
            for (int i = 0; i < n; i++) {
                Subject subject = new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine());
                subjects.add(subject);
            }
            return subjects;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Subject {
        private String code;
        private String name;
        private String format;

        public Subject(String code, String name, String format) {
            this.code = code;
            this.name = name;
            this.format = format;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + format;
        }
    }
}
