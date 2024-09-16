import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int length = sc.nextInt();
            int width = sc.nextInt();
            if (length <= 0 || width <= 0) {
                System.out.println("0");
            } else {
                int perimeter = calculateRectanglePerimeter(length, width);
                int area = calculateRectangleArea(length, width);
                System.out.println(perimeter + " " + area);
            }
        }
    }

    private static int calculateRectanglePerimeter(int l, int w) {
        return 2 * (l + w);
    }

    private static int calculateRectangleArea(int l, int w) {
        return l * w;
    }
}
