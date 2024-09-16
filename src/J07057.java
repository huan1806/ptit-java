import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07057 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Candidate> candidates = getCandidates();
        candidates.sort(Comparator.comparing(Candidate::getTotalScore).reversed().thenComparing(Candidate::getCode));
        candidates.forEach(System.out::println);
    }

    private static List<Candidate> getCandidates() {
        try (Scanner sc = new Scanner(new File("THISINH.in"))) {
            int n = sc.nextInt();
            List<Candidate> candidates = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                String name = sc.nextLine();
                double score = sc.nextDouble();
                sc.nextLine();
                String ethnic = sc.nextLine();
                String region = sc.next();
                Candidate candidate = new Candidate(name, score, ethnic, region);
                candidates.add(candidate);
            }
            return candidates;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Candidate {

        private static final AtomicInteger counter = new AtomicInteger(1);

        private final String code = String.format("TS%02d", counter.getAndIncrement());
        private String name;
        private double score;
        private String ethnic;
        private String region;

        public Candidate(String name, double score, String ethnic, String region) {
            this.name = Helper.formatName(name);
            this.score = score;
            this.ethnic = ethnic;
            this.region = region;
        }

        public String getCode() {
            return code;
        }

        public double getTotalScore() {
            return score + getRegionalBonus() + getEthnicBonus();
        }

        public double getRegionalBonus() {
            if ("1".equals(region)) {
                return 1.5;
            }
            if ("2".equals(region)) {
                return 1;
            }
            return 0;
        }

        public double getEthnicBonus() {
            return "Kinh".equals(ethnic) ? 0 : 1.5;
        }

        public String getResult() {
            return getTotalScore() >= 20.5 ? "Do" :"Truot";
        }

        @Override
        public String toString() {
            return String.format("%s %s %.1f %s", code, name, getTotalScore(), getResult());
        }
    }

    private static class Helper {
        public static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }
    }
}
