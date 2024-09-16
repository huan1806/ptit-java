package J04018;

import java.util.Scanner;

public class J04018 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                ComplexNumber A = new ComplexNumber(sc.nextInt(), sc.nextInt());
                ComplexNumber B = new ComplexNumber(sc.nextInt(), sc.nextInt());
                ComplexNumber S = A.add(B);
                ComplexNumber C = S.multiply(A);
                ComplexNumber D = S.multiply(S);
                System.out.printf("%s, %s%n", C, D);
            }
        }
    }
}
