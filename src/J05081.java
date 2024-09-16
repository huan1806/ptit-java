import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05081 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Product> products = getProducts(n, sc);
            products.sort(Comparator.comparing(Product::getProfit).reversed().thenComparing(Product::getId));
            products.forEach(System.out::println);
        }
    }

    private static List<Product> getProducts(int n, Scanner sc) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            String unit = sc.nextLine();
            int purchasePrice = sc.nextInt();
            int sellingPrice = sc.nextInt();
            Product product = new Product(name, unit, purchasePrice, sellingPrice);
            products.add(product);
        }
        return products;
    }

    private static class Product {

        private static int numberOfProducts = 0;
        private int id = ++numberOfProducts;
        private String name;
        private String unit;
        private int purchasePrice;
        private int sellingPrice;

        public Product(String name, String unit, int purchasePrice, int sellingPrice) {
            this.name = name;
            this.unit = unit;
            this.purchasePrice = purchasePrice;
            this.sellingPrice = sellingPrice;
        }

        public int getId() {
            return id;
        }

        public String getCode() {
            return String.format("MH%03d", id);
        }

        public int getProfit() {
            return sellingPrice - purchasePrice;
        }

        @Override
        public String toString() {
            return getCode() + " " + name + " " + unit + " " + purchasePrice + " " + sellingPrice + " " + getProfit();
        }
    }
}
