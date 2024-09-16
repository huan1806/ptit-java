import java.util.Scanner;

public class J04008 {
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
                    System.out.printf("%.3f%n", triangle.getPerimeter());
                } else {
                    System.out.println("INVALID");
                }
            }
        }
    }

    private static class Point {

        private double x;
        private double y;

        public Point() {
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distance(Point secondPoint) {
            return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
        }

        public double distance(Point p1, Point p2) {
            return p1.distance(p2);
        }

        @Override
        public String toString() {
            return String.format("(x,y) = (%.2f, %.2f)", x, y);
        }
    }

    private static class Triangle {
        private final double a;
        private final double b;
        private final double c;

        public Triangle(Point point1, Point point2, Point point3) {
            this.a = point1.distance(point2);
            this.b = point2.distance(point3);
            this.c = point3.distance(point1);
        }

        public boolean isValid() {
            return a + b > c && a + c > b && b + c > a;
        }

        public double getPerimeter() {
            return a + b + c;
        }

        public double getArea() {
            double p = getPerimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }
}
