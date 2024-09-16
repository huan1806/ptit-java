package J04014;

import java.util.Scanner;

public class J04014 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                Fraction A = new Fraction(sc.nextInt(), sc.nextInt());
                Fraction B = new Fraction(sc.nextInt(), sc.nextInt());
                Fraction tempA = new Fraction(A);
                Fraction C = A.add(B).square();
                Fraction D = tempA.multiply(B).multiply(C);
                System.out.printf("%s %s%n", C, D);
            }
        }
    }
}
