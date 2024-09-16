package J04010;

import java.util.Scanner;

public class J04010 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                Point point1 = new Point(sc.nextDouble(), sc.nextDouble());
                Point point2 = new Point(sc.nextDouble(), sc.nextDouble());
                Point point3 = new Point(sc.nextDouble(), sc.nextDouble());
                Triangle triangle = new Triangle(point1, point2, point3);
                if (triangle.isValid()) {
                    double r = triangle.getCircumradius();
                    System.out.printf("%.3f%n", Math.PI * r * r);
                } else {
                    System.out.println("INVALID");
                }
            }
        }
    }
}
