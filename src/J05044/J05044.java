package J05044;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05044 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Payroll> payrolls = getPayrolls(sc);
            sc.nextLine();
            String position = sc.nextLine();
            payrolls.stream().filter(payroll -> position.equals(payroll.getPosition())).forEach(System.out::println);
        }

    }

    private static List<Payroll> getPayrolls(Scanner sc) {
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
