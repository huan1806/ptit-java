package J04019;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(Point point1, Point point2, Point point3) {
        this.a = point1.distance(point2);
        this.b = point2.distance(point3);
        this.c = point3.distance(point1);
    }

    public boolean valid() {
        return a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
        return round(a + b + c, 3);
    }

    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        return (double) Math.round(value * factor) / factor;
    }
}
