package J04013;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class J04013 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(System.in)) {
            Candidate candidate = new Candidate(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextDouble(),
                    sc.nextDouble(),
                    sc.nextDouble()
            );
            System.out.println(candidate);
        }
    }
}
