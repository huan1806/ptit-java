package J05006;

import java.util.Scanner;

public class J05006 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
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
                System.out.println(employee);
            }
        }
    }
}
