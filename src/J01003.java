import java.util.Scanner;

public class J01003 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0) {
                if (b == 0) {
                    System.out.println("VSN");
                } else {
                    System.out.println("VN");
                }
            } else {
                System.out.printf("%.2f", -(float) b / a);
            }
        }
    }
}