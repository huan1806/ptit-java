package J05045;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05045 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Payroll> payrolls = getPayrolls();
        payrolls.sort(Comparator.comparing(Payroll::getSalary).reversed());
        payrolls.forEach(System.out::println);
    }

    private static List<Payroll> getPayrolls() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Payroll> payrolls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Payroll payroll = new Payroll(
                        new Employee(sc.nextLine(), sc.nextLine()),
                        sc.nextLong(),
                        sc.nextLong()
                );
                payrolls.add(payroll);
            }
            return payrolls;
        }
    }
}
