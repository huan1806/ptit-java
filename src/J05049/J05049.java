package J05049;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05049 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Product> products = getProducts(sc);
            String group = sc.next();
            products.stream().filter(product -> product.getCode().startsWith(group))
                    .sorted(Comparator.comparing(Product::getTax).reversed())
                    .forEach(System.out::println);
        }
    }

    private static List<Product> getProducts(Scanner sc) {
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


