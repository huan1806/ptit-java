package J05011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05011 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Account> accounts = readList();
        accounts.sort(Comparator.comparing(Account::getPlayingTimeInMinutes).reversed());
        accounts.forEach(System.out::println);
    }

    private static List<Account> readList() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Account> accounts = new ArrayList<>();
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                Account account = new Account(sc.nextLine(), sc.nextLine(),  sc.nextLine(),  sc.nextLine());
                accounts.add(account);
            }
            return accounts;
        }
    }
}
