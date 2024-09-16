import java.util.Scanner;

public class J04005 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Student student = new Student(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextDouble(),
                    sc.nextDouble(),
                    sc.nextDouble()
            );
            System.out.println(student);
        }
    }

    private static class Student {
        private String name;
        private String dob;
        private double score1;
        private double score2;
        private double score3;

        public Student(String name, String dob, double score1, double score2, double score3) {
            this.name = name;
            this.dob = dob;
            this.score1 = score1;
            this.score2 = score2;
            this.score3 = score3;
        }

        public double getTotalScore() {
            return score1 + score2 + score3;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.1f", name, dob, getTotalScore());
        }
    }
}
