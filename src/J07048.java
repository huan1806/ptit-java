import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07048 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("SANPHAM.in"))) {
            int n = sc.nextInt();
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Product product = new Product(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextInt(),
                        sc.nextInt()
                );
                products.add(product);
            }
            products.sort(Comparator.comparing(Product::getSellingPrice).reversed().thenComparing(Product::getCode));
            products.forEach(System.out::println);
        }
    }

    private static class Product {
        private String code;
        private String name;
        private int sellingPrice;
        private int warrantyPeriod;

        public Product(String code, String name, int sellingPrice, int warrantyPeriod) {
            this.code = code;
            this.name = name;
            this.sellingPrice = sellingPrice;
            this.warrantyPeriod = warrantyPeriod;
        }

        public String getCode() {
            return code;
        }

        public int getSellingPrice() {
            return sellingPrice;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + sellingPrice + " " + warrantyPeriod;
        }
    }
}
