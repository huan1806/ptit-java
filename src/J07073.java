import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07073 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Subject> subjects = getSubjects();
        subjects.stream().filter(Subject::isPracticalTeachingMethodOnline)
                .sorted(Comparator.comparing(Subject::getCode))
                .forEach(System.out::println);
    }

    private static List<Subject> getSubjects() {
        try (Scanner sc = new Scanner(new File("MONHOC.in"))) {
            List<Subject> subjects = new ArrayList<>();
            int n = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < n; i++) {
                Subject subject = new Subject(
                        sc.nextLine(),
                        sc.nextLine(),
                        Integer.parseInt(sc.nextLine().trim()),
                        sc.nextLine(),
                        sc.nextLine()
                );
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
        private int credit;
        private String lectureTeachingMethod;
        private String practicalTeachingMethod;

        public Subject(String code, String name, int credit, String lectureTeachingMethod, String practicalTeachingMethod) {
            this.code = code;
            this.name = name;
            this.credit = credit;
            this.lectureTeachingMethod = lectureTeachingMethod;
            this.practicalTeachingMethod = practicalTeachingMethod;
        }

        public String getCode() {
            return code;
        }

        public boolean isPracticalTeachingMethodOnline() {
            return !"Truc tiep".equals(practicalTeachingMethod);
        }

        @Override
        public String toString() {
            return code + " " + name + " " + credit + " " + lectureTeachingMethod + " " + practicalTeachingMethod;
        }
    }
}
