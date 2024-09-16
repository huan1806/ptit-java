import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class J07005 {
    private static final int MAX = 1002;

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (InputStream inputStream = new FileInputStream("DATA.IN");
             DataInputStream dataInputStream = new DataInputStream(inputStream)
        ) {
            int[] count = new int[MAX];
            for (int i = 0; i < 100000; i++) {
                count[dataInputStream.readInt()]++;
            }
            for (int i = 0; i < MAX; i++) {
                if (count[i] > 0) {
                    System.out.printf("%d %d%n", i, count[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
