package J05003;

import java.util.Scanner;

public class J05003 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            while (n-- > 0) {
                sc.nextLine();
                Student student = new Student(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextDouble()
                );
                System.out.println(student);
            }
        }
    }
}
