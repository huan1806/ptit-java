package J05053;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05053 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Item> items = getItems();
        items.sort(Comparator.comparing(Item::getOrderNumber));
        items.forEach(System.out::println);
    }

    private static List<Item> getItems() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                items.add(new Item(sc.nextLine(), sc.next(), sc.nextLong(), sc.nextLong()));
            }
            return items;
        }
    }
}
