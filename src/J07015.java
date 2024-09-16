import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class J07015 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        solve();
    }

    private static void solve() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("SONGUYEN.in");
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            boolean[] primes = primes();
            @SuppressWarnings("unchecked")
            List<Integer> list = (ArrayList<Integer>) objectInputStream.readObject();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            list.forEach(num -> {
                if (primes[num]) {
                    map.merge(num, 1, Integer::sum);
                }
            });
            map.forEach((key, value) -> {
                System.out.printf("%d %d%n", key, value);
            });
        }
    }

    private static boolean[] primes() {
        boolean[] primes = new boolean[10000];
        Arrays.fill(primes, 2, 10000, true);
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2 * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
