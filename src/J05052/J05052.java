package J05052;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05052 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Item> items = getItems();
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
