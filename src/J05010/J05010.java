package J05010;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05010 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Product> products = readList();
        products.sort(Comparator.comparing(Product::getProfit).reversed());
        products.forEach(System.out::println);
    }

    private static List<Product> readList() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Product> products = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                sc.nextLine();
                Product product = new Product(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
                products.add(product);
            }
            return products;
        }
    }
}
