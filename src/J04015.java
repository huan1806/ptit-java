import java.util.Scanner;

public class J04015 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Teacher teacher = new Teacher(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextInt()
            );
            System.out.println(teacher);
        }
    }

    private static class Teacher {

        private String code;
        private String name;
        private int baseSalary;
        private String tier;
        private int coefficient;

        public Teacher(String code, String name, int baseSalary) {
            this.code = code;
            this.name = name;
            this.baseSalary = baseSalary;
            this.tier = code.substring(0, 2);
            this.coefficient = Integer.parseInt(code.substring(2));
        }

        public int getAllowance() {
            switch (tier) {
                case "HT":
                    return  2000000;
                case "HP":
                    return  900000;
                case "GV":
                    return  500000;
                default:
                    return 0;
            }
        }

        public int getSalary() {
            return coefficient * baseSalary + getAllowance();
        }

        @Override
        public String toString() {
            return code + " " + name + " " + coefficient + " " + getAllowance() + " " + getSalary();
        }
    }
}
