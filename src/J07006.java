import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class J07006 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        solve();
    }

    private static void solve() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("DATA.in"))) {
            TreeMap<Integer, Integer> count = new TreeMap<>();
            @SuppressWarnings("unchecked")
            List<Integer> list = (ArrayList<Integer>) inputStream.readObject();
            list.forEach(num -> count.merge(num, 1, Integer::sum));
            count.forEach((key, value) -> System.out.printf("%d %d%n", key, value));
        }
    }
}
