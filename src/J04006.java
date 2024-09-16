import java.util.Scanner;

public class J04006 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Student student = new Student(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextDouble()
            );
            System.out.println(student);
        }
    }

    private static class Student {
        private String id;
        private String fullName;
        private String clazz;
        private String dob;
        private double gpa;

        public Student() {
        }

        public Student(String fullName, String clazz, String dob, double gpa) {
            this.id = "B20DCCN001";
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
