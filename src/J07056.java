import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07056 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Customer> customers = getCustomers();
        customers.sort(Comparator.comparing(Customer::getTotalPayment).reversed());
        customers.forEach(System.out::println);
    }

    private static List<Customer> getCustomers() {
        try (Scanner sc = new Scanner(new File("KHACHHANG.in"))) {
            int n = sc.nextInt();
            List<Customer> customers = new ArrayList<Customer>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Customer customer = new Customer(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt());
                customers.add(customer);
            }
            return customers;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Customer {

        private static final Map<String, Integer> QUOTAS = new HashMap<String, Integer>() {{
            put("A", 100);
            put("B", 500);
            put("C", 200);
        }};

        private static final AtomicInteger counter = new AtomicInteger(1);

        private final String code = String.format("KH%02d", counter.getAndIncrement());
        private String name;
        private String type;
        private int previousIndex;
        private int currentIndex;
        private int inQuotaPayment;
        private int overQuotaPayment;
        private int vat;
        private int totalPayment;

        public Customer(String name, String type, int previousIndex, int currentIndex) {
            this.name = Helper.formatName(name);
            this.type = type;
            this.previousIndex = previousIndex;
            this.currentIndex = currentIndex;
            setPayment();
        }

        public int getTotalPayment() {
            return totalPayment;
        }

        private void setPayment() {
            int quota = QUOTAS.getOrDefault(type, 0);
            inQuotaPayment = 450 * Math.min(quota, currentIndex - previousIndex);
            overQuotaPayment = 1000 * Math.max(0, currentIndex - previousIndex - quota);
            vat = overQuotaPayment * 5 / 100;
            totalPayment = inQuotaPayment + overQuotaPayment + vat;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d %d %d", code, name, inQuotaPayment, overQuotaPayment, vat, totalPayment);
        }
    }

    private static class Helper {
        public static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }
    }
}
