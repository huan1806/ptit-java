package J05036;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05036 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Item> items = getItems();
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
