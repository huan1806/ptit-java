package J05009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05009 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Candidate> candidates = readList();
        double max = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getTotalScore() > max) {
                max = candidate.getTotalScore();
            }
        }
        for (Candidate candidate : candidates) {
            if (candidate.getTotalScore() == max) {
                System.out.println(candidate);
            }
        }
    }

    private static List<Candidate> readList() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Candidate> candidates = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                sc.nextLine();
                Candidate candidate = new Candidate(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                candidates.add(candidate);
            }
            return candidates;
        }
    }
}

