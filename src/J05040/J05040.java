package J05040;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05040 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Payroll> payrolls = getPayrolls();
        payrolls.forEach(System.out::println);
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
