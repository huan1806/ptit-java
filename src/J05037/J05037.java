package J05037;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05037 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Item> items = getItems();
        items.sort(Comparator.comparing(Item::getSellingPrice).reversed());
        items.forEach(System.out::println);
    }

    private static List<Item> getItems() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Item> items = new ArrayList<>();
            int n = sc.nextInt();
            while (n-- > 0) {
                sc.nextLine();
                Item item = new Item(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
                items.add(item);
            }
            return items;
        }
    }
}
