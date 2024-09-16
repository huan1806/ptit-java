import java.util.Scanner;

public class J04011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Point3D p1 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(), sc.nextInt(), sc.nextInt());

            if (Point3D.check(p1, p2, p3, p4)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            System.gc();
        }
    }

    private static class Point3D {
        private final int x;
        private final int y;
        private final int z;

        public Point3D(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
            Vector AB = new Vector(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
            Vector AC = new Vector(p3.x - p1.x, p3.y - p1.y, p3.z - p1.z);
            Vector AD = new Vector(p4.x - p1.x, p4.y - p1.y, p4.z - p1.z);
            Vector n = AB.crossProduct(AC);
            return n.dotProduct(AD) == 0;
        }
    }

    private static class Vector {
        private final int x;
        private final int y;
        private final int z;

        public Vector(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int dotProduct(Vector v) {
            return this.x * v.x + this.y * v.y + this.z * v.z;
        }

        public Vector crossProduct(Vector v) {
            return new Vector(
                    this.y * v.z - this.z * v.y,
                    this.z * v.x - this.x * v.z,
                    this.x * v.y - this.y * v.x
            );
        }
    }
}
