import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07034 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("MONHOC.in"))) {
            int n = sc.nextInt();
            List<Subject> subjects = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Subject subject = new Subject(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextInt()
                );
                subjects.add(subject);
            }
            subjects.sort(Comparator.comparing(Subject::getName));
            subjects.forEach(System.out::println);
        }
    }

    private static class Subject {
        private String code;
        private String name;
        private int credits;

        public Subject(String code, String name, int credits) {
            this.code = code;
            this.name = name;
            this.credits = credits;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + credits;
        }
    }
}
