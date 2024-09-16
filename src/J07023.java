import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class J07023 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr1 = countSpecialNumbers("DATA1.in");
            int[] arr2 = countSpecialNumbers("DATA2.in");
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] > 0 && arr2[i] > 0) {
                    System.out.printf("%d %d %d%n", i, arr1[i], arr2[i]);
                }
            }
        }
    }

    private static int[] countSpecialNumbers(String fileName) {
        List<Integer> list = readData(fileName);
        return mark(list);
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> readData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return (List<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] mark(List<Integer> list) {
        int[] result = new int[10000];
        for (int num : list) {
            if (isPrime(num) && isAPalindrome(num)) {
                result[num]++;
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAPalindrome(int n) {
        int temp = n;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return n == reverse;
    }
}
