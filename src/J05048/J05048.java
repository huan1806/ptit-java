package J05048;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05048 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Product> products = getProducts();
        products.forEach(System.out::println);
    }

    private static List<Product> getProducts() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Product> products = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Product product = new Product(sc.nextLine(), sc.nextLong());
                products.add(product);
            }
            return products;
        }
    }
}


