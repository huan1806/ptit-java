import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class J07040 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        solve();
    }

    private static void solve() throws IOException, ClassNotFoundException {
        Set<String> binarySet = readBinaryFile();
        Set<String> docSet = readDocFile();
        docSet.retainAll(binarySet);
        docSet.forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
    private static Set<String> readBinaryFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("NHIPHAN.in"))) {
            List<String> stringList = (ArrayList<String>) objectInputStream.readObject();
            Set<String> set = new HashSet<>();
            for (String s : stringList) {
                if (s != null) {
                    String[] words = s.trim().split("\\s+");
                    for (String word : words) {
                        set.add(word.toLowerCase());
                    }
                }
            }
            return set;
        }
    }

    private static Set<String> readDocFile() throws IOException {
        try (Scanner sc = new Scanner(new File("VANBAN.in"))) {
            Set<String> set = new LinkedHashSet<>();
            while (sc.hasNext()) {
                set.add(sc.next().toLowerCase());
            }
            return set;
        }
    }
}
