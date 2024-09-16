import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class J07032 {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Map<Integer, Integer> map1 = readData("DATA1.in");
        Map<Integer, Integer> map2 = readData("DATA2.in");
        TreeMap<Integer, Integer> intersectionMap = new TreeMap<>();
        map1.forEach((k, v) -> {
            if (map2.containsKey(k)) {
                intersectionMap.merge(k, map2.get(k) + v, Integer::sum);
            }
        });
        intersectionMap.entrySet().stream()
                .filter(entry -> isSpecialPalindromic(entry.getKey()))
                .limit(10).forEach(entry -> System.out.printf("%d %d%n", entry.getKey(), entry.getValue()));
    }

    private static boolean isSpecialPalindromic(int n) {
        int temp = n;
        int reversed = 0;
        int digitCount = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit % 2 == 0) {
                return false;
            }
            reversed = reversed * 10 + digit;
            temp /= 10;
            digitCount++;
        }
        return reversed == n && digitCount % 2 == 1;
    }

    private static Map<Integer, Integer> readData(String filename) {
        List<Integer> list = readList(filename);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.merge(num, 1, Integer::sum);
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> readList(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
