import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05029 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Enterprise> enterprises = getEnterprises(sc);
            List<List<Integer>> queries = getQueries(sc);
            queries.forEach(query -> {
                System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:%n", query.get(0), query.get(1));
                enterprises.stream().filter(enterprise -> enterprise.getStudentNumToReceive() >= query.get(0)
                                && enterprise.getStudentNumToReceive() <= query.get(1))
                        .sorted(Comparator.comparing(Enterprise::getStudentNumToReceive).reversed()
                                .thenComparing(Enterprise::getCode))
                        .forEach(System.out::println);
            });
        }
    }

    private static List<Enterprise> getEnterprises(Scanner sc) {
        int n = sc.nextInt();
        List<Enterprise> enterprises = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            Enterprise enterprise = new Enterprise(sc.nextLine(), sc.nextLine(), sc.nextInt());
            enterprises.add(enterprise);
        }
        return enterprises;
    }

    private static List<List<Integer>> getQueries(Scanner sc) {
        int q = sc.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(sc.nextInt());
            query.add(sc.nextInt());
            queries.add(query);
        }
        return queries;
    }

    private static class Enterprise {
        private final String code;
        private final String name;
        private final int studentNumToReceive;

        public Enterprise(String code, String name, int studentNumToReceive) {
            this.code = code;
            this.name = name;
            this.studentNumToReceive = studentNumToReceive;
        }

        public String getCode() {
            return code;
        }

        public int getStudentNumToReceive() {
            return studentNumToReceive;
        }

        @Override
        public String toString() {
            return code + " " + name + " " + studentNumToReceive;
        }
    }
}
