package J05050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05050 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<ElectricityBill> bills = getElectricityBills();
        bills.forEach(System.out::println);
    }

    private static List<ElectricityBill> getElectricityBills() {
        try (Scanner sc = new Scanner(System.in)) {
            List<ElectricityBill> bills = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                bills.add(new ElectricityBill(sc.next(), sc.nextLong(), sc.nextLong()));
            }
            return bills;
        }
    }
}
