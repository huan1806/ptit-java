import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07008 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        File file = new File("DAYSO.in");
        try (Scanner sc = new Scanner(file)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            List<String> combinations = new ArrayList<>();
            findCombinations(0, arr, new ArrayList<>(), combinations);
            combinations.sort(String::compareTo);
            combinations.forEach(System.out::println);
        }
    }

    private static void findCombinations(int index, int[] arr, List<Integer> currentList, List<String> combination) {
        for (int i = index; i < arr.length; i++) {
            int curSize = currentList.size();
            if (curSize == 0 || currentList.get(curSize - 1) < arr[i]) {
                currentList.add(arr[i]);
                if (curSize > 0) {
                    combination.add(listToString(currentList));
                }
                findCombinations(i + 1, arr, currentList, combination);
                currentList.remove(curSize);
            }
        }
    }

    private static String listToString(List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
