import java.util.Scanner;

public class J04007 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Employee employee = new Employee(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextLine()
            );
            System.out.println(employee);
        }
    }

    private static class Employee {

        private String id;
        private String name;
        private String sex;
        private String dob;
        private String address;
        private String taxCode;
        private String contractDate;

        public Employee(String name, String sex, String dob, String address, String taxCode, String contractDate) {
            this.id = "00001";
            this.name = name;
            this.sex = sex;
            this.dob = dob;
            this.address = address;
            this.taxCode = taxCode;
            this.contractDate = contractDate;
        }

        // getters and setters are not necessary

        @Override
        public String toString() {
            return id + " " + name + " " + sex + " " + dob + " " + address + " " + taxCode + " " + contractDate;
        }
    }
}
