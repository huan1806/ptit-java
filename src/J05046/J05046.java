package J05046;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05046 {
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
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Item item = new Item(sc.nextLine(), sc.nextLong(), sc.nextLong());
                items.add(item);
            }
            return items;
        }
    }
}
