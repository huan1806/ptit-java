package J05038;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05038 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Payroll> payrolls = getPayrolls();
        long payrollCosts = 0;
        for (Payroll payroll : payrolls) {
            payrollCosts += payroll.getGrossSalary();
            System.out.println(payroll);
        }
        System.out.printf("Tong chi phi tien luong: %d%n", payrollCosts);
    }

    private static List<Payroll> getPayrolls() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Payroll> payrolls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = sc.nextLine();
                long dailyPaid = sc.nextLong();
                long workingDays = sc.nextLong();
                sc.nextLine();
                String position = sc.nextLine();
                Payroll payroll = new Payroll(
                        new Employee(name, position),
                        dailyPaid,
                        workingDays
                );
                payrolls.add(payroll);
            }
            return payrolls;
        }
    }
}
