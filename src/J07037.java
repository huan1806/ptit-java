import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07037 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("DN.in"))) {
            int n = sc.nextInt();
            List<Business> businesses = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Business business = new Business(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextInt()
                );
                businesses.add(business);
            }
            businesses.sort(Comparator.comparing(Business::getCode));
            businesses.forEach(System.out::println);
        }
    }

    private static class Business {
        private String code;
        private String name;
        private int studentsReceiving;

        public Business(String code, String name, int studentsReceiving) {
            this.code = code;
            this.name = name;
            this.studentsReceiving = studentsReceiving;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + studentsReceiving;
        }
    }
}
