package J04019;

import java.util.Scanner;

public class Point {
    private double x, y;

    public Point() {}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public double distance(Point p1, Point p2) {
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return String.format("(x,y) = (%.2f, %.2f)", x, y);
    }
}
