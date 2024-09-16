import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

public class J07030 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        boolean[] primes = primes();
        int[] primes1 = countPrimes(primes, "DATA1.in");
        int[] primes2 = countPrimes(primes, "DATA2.in");
        for (int i = 2; i < MAX / 2; i++) {
            if (primes1[i] > 0 && primes2[MAX - i] > 0) {
                System.out.printf("%d %d%n", i, MAX - i);
            }
        }
    }


    private static int[] countPrimes(boolean[] primes, String fileName) {
        List<Integer> nums = readList(fileName);
        int[] result = new int[primes.length];
        for (int num : nums) {
            if (primes[num]) {
                result[num]++;
            }
        }
        return result;
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
