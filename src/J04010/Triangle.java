package J04010;

public class Triangle {
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

    public double getCircumradius() {
        return a * b * c / (4 * getArea());
    }
}
