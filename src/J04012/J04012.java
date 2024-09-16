package J04012;

import java.util.Scanner;

public class J04012 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Employee employee = new Employee(
                    sc.nextLine(),
                    sc.nextInt(),
                    sc.nextInt(),
                    Position.valueOf(sc.next())
            );
            System.out.println(employee);
        }
    }
}
