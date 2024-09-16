package J05007;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05007 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Employee> employees = readList();
        employees.sort(Comparator.comparing(Employee::getDob));
        employees.forEach(System.out::println);
    }

    private static List<Employee> readList() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Employee> list = new ArrayList<>();
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                Employee employee = new Employee(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine()
                );
                list.add(employee);
            }
            return list;
        }
    }
}
