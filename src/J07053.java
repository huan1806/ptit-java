import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07053 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("XETTUYEN.in"))) {
            List<Candidate> candidates = getCandidates(sc);
            candidates.forEach(System.out::println);
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
                    sc.nextDouble()
            );
            candidates.add(candidate);
        }
        return candidates;
    }

    private static class Candidate {
        private static final AtomicInteger count = new AtomicInteger(1);
        private final String code = String.format("PH%02d", count.getAndIncrement());
        private String fullName;
        private String dob;
        private double theoreticalScore;
        private double practiceScore;
        private int totalScore;

        public Candidate(String fullName, String dob, double theoreticalScore, double practiceScore) {
            this.fullName = Helper.formatName(fullName);
            this.dob = Helper.formatDate(dob);
            this.theoreticalScore = theoreticalScore;
            this.practiceScore = practiceScore;
            this.totalScore = calculateTotalScore();
        }

        public String getClassification() {
            switch (totalScore) {
                case 10:
                case 9:
                    return "Xuat sac";
                case 8:
                    return "Gioi";
                case 7:
                    return "Kha";
                case 6:
                case 5:
                    return "Trung binh";
                default:
                    return "Truot";
            }
        }

        private int calculateTotalScore() {
            return Math.min((int) Math.round((theoreticalScore + practiceScore) / 2 + getBonusScore()), 10);
        }

        private double getBonusScore() {
            if (theoreticalScore >= 8 && practiceScore >= 8) {
                return 1;
            }
            if (theoreticalScore >= 7.5 && practiceScore >= 7.5) {
                return 0.5;
            }
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%s %s %d %d %s", code, fullName, Helper.yearsTo2021(dob),
                    totalScore, getClassification());
        }
    }

    private static final class Helper {
        public static String formatDate(String date) {
            if ('/' == date.charAt(1)) {
                date = "0" + date;
            }
            if ('/' == date.charAt(4)) {
                date = date.substring(0, 3) + "0" + date.substring(3);
            }
            return date;
        }

        public static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }

        public static int yearsTo2021(String date) {
            String[] frags = date.split("/");
            if (frags.length == 3) {
                return 2021 - Integer.parseInt(frags[2]);
            }
            return 0;
        }
    }
}
