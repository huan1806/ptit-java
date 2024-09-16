import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J07052 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("THISINH.in"))) {
            List<Candidate> candidates = getCandidates(sc);
            int quotas = sc.nextInt();
            candidates.sort(Comparator.comparing(Candidate::getTotalScore).reversed().thenComparing(Candidate::getCode));
            double benchmarkScore = 0;
            if (quotas < candidates.size()) {
                benchmarkScore = candidates.get(quotas - 1).getTotalScore();
            } else {
                benchmarkScore = candidates.get(candidates.size() - 1).getTotalScore();
            }
            System.out.printf("%.1f%n", benchmarkScore);
            for (Candidate candidate : candidates) {
                candidate.setStatus(candidate.getTotalScore() >= benchmarkScore ? "TRUNG TUYEN" : "TRUOT");
                System.out.println(candidate);
            }
        }
    }

    private static List<Candidate> getCandidates(Scanner sc) {
        int n = sc.nextInt();
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            Candidate candidate = new Candidate(
                    sc.nextLine(),
                    sc.nextLine(),
                    sc.nextDouble(),
                    sc.nextDouble(),
                    sc.nextDouble()
            );
            candidates.add(candidate);
        }
        return candidates;
    }

    private static final class Candidate {
        private String code;
        private String name;
        private double mathScore;
        private double physicScore;
        private double chemistryScore;
        private double totalScore;
        private String status;

        public Candidate(String code, String name, double mathScore, double physicScore, double chemistryScore) {
            this.code = code;
            this.name = formatName(name);
            this.mathScore = mathScore;
            this.physicScore = physicScore;
            this.chemistryScore = chemistryScore;
            this.totalScore = calculateScore();
        }

        public String getCode() {
            return code;
        }

        public double getTotalScore() {
            return totalScore;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        private String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }

        private double calculateScore() {
            return 2 * mathScore + physicScore + chemistryScore + getPriorityPoint();
        }

        private double getPriorityPoint() {
            char region = code.charAt(2);
            switch (region) {
                case '1':
                    return 0.5;
                case '2':
                    return 1;
                case '3':
                    return 2.5;
                default:
                    return 0;
            }
        }

        private String doubleToString(double d) {
            if (d == (int) d) {
                return String.valueOf((int) d);
            }
            return String.format("%.1f", d);
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s %s", code, name, doubleToString(getPriorityPoint()),
                    doubleToString(getTotalScore()), status);
        }
    }
}
