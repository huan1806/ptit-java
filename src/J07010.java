import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class J07010 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("SV.in");
        try (Scanner sc = new Scanner(file)) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Student student = new Student(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextDouble()
                );
                System.out.println(student);
            }
        }
    }

    private static class Student {
        private static final AtomicInteger counter = new AtomicInteger(0);
        private String id;
        private String fullName;
        private String clazz;
        private String dob;
        private double gpa;

        public Student(String fullName, String clazz, String dob, double gpa) {
            this.id = String.format("B20DCCN%03d", counter.incrementAndGet());
            this.fullName = fullName;
            this.clazz = clazz;
            this.dob = standardizeDate(dob);
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s %.2f", id, fullName, clazz, dob, gpa);
        }

        private String standardizeDate(String date) {
            if ('/' == date.charAt(1)) {
                date = "0" + date;
            }
            if ('/' == date.charAt(4)) {
                date = date.substring(0, 3) + "0" + date.substring(3);
            }
            return date;
        }
    }
}
