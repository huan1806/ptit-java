import java.util.Scanner;

public class J04002 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            String color = sc.next();

            Rectangle rectangle = new Rectangle(w, h, capitalize(color));
            System.out.println(rectangle);
        }
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}

class Rectangle {
    private int width;
    private int height;
    private String color;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int findArea() {
        return width * height;
    }

    public int findPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        if (width <= 0 || height <= 0) {
            return "INVALID";
        }
        return findPerimeter() + " " + findArea() + " " + color;
    }
}
