import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class J07050 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("MATHANG.in"))) {
            int n = sc.nextInt();
            List<Product> products = getProducts(n, sc);
            products.sort(Comparator.comparing(Product::getProfit).reversed());
            products.forEach(System.out::println);
        }
    }

    private static List<Product> getProducts(int n, Scanner sc) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            String unit = sc.nextLine();
            double purchasePrice = sc.nextDouble();
            double sellingPrice = sc.nextDouble();
            Product product = new Product(name, unit, purchasePrice, sellingPrice);
            products.add(product);
        }
        return products;
    }

    private static class Product {

        private static final AtomicInteger count = new AtomicInteger(1);
        private String code;
        private String name;
        private String group;
        private double purchasePrice;
        private double sellingPrice;

        public Product(String name, String group, double purchasePrice, double sellingPrice) {
            this.code = String.format("MH%02d", count.getAndIncrement());
            this.name = name;
            this.group = group;
            this.purchasePrice = purchasePrice;
            this.sellingPrice = sellingPrice;
        }

        public String getCode() {
            return code;
        }

        public double getProfit() {
            return sellingPrice - purchasePrice;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %.2f", code, name, group, getProfit());
        }
    }
}
