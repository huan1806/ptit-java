import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class J07031 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        boolean[] primes = primes();
        Set<Integer> primes1 = getPrimes(primes, "DATA1.in");
        Set<Integer> primes2 = getPrimes(primes, "DATA2.in");
        for (int prime1 : primes1) {
            if (prime1 >= MAX / 2) {
                break;
            }
            int num2 = MAX - prime1;
            if (primes1.contains(num2) && !primes2.contains(prime1) && !primes2.contains(num2)) {
                System.out.printf("%d %d%n", prime1, num2);
            }
        }
    }


    private static Set<Integer> getPrimes(boolean[] primes, String fileName) {
        Set<Integer> setPrimes = new TreeSet<>();
        List<Integer> list = readList(fileName);
        for (int num : list) {
            if (primes[num]) {
                setPrimes.add(num);
            }
        }
        return setPrimes;
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> readList(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean[] primes() {
        boolean[] primes = new boolean[MAX];
        Arrays.fill(primes, 2, MAX, true);
        for (int i = 2; i < MAX; i++) {
            if (primes[i]) {
                for (int j = 2 * i; j < MAX; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
