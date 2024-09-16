import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J02021 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            generate(1, n, k, new ArrayList<>());
            System.out.printf("%nTong cong co %d to hop", numberOfCombinations(n, k));
        }
    }

    private static void generate(int start, int n, int k, List<Integer> list) {
        int size = list.size();
        if (size == k) {
            printCombination(list);
            return;
        }
        for (int i = start; i <= n - k + size + 1; i++) {
            list.add(i);
            generate(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }

    private static void printCombination(List<Integer> list) {
        list.forEach(System.out::print);
        System.out.print(" ");
    }

    private static int numberOfCombinations(int n, int k) {
        int ret = 1;
        for (int i = 1; i <= k; i++) {
            ret = ret * (n - i + 1) / i;
        }
        return ret;
    }
}
