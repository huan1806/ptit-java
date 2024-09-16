import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07055 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Transcript> transcripts = getTranscripts();
        transcripts.sort(Comparator.comparing(Transcript::getAverageScore).reversed());
        transcripts.forEach(System.out::println);
    }

    private static List<Transcript> getTranscripts() {
        try (Scanner sc = new Scanner(new File("BANGDIEM.in"))) {
            int n = sc.nextInt();
            List<Transcript> transcripts = new ArrayList<Transcript>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Transcript transcript = new Transcript(
                        sc.nextLine(),
                        sc.nextDouble(),
                        sc.nextDouble(),
                        sc.nextDouble()
                );
                transcripts.add(transcript);
            }
            return transcripts;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Transcript {
        private static final AtomicInteger counter = new AtomicInteger(1);
        private final String code = String.format("SV%02d", counter.getAndIncrement());
        private String name;
        private double practiceScore;
        private double onlineScore;
        private double examScore;
        private double averageScore;

        public Transcript(String name, double practiceScore, double onlineScore, double examScore) {
            this.name = Helper.formatName(name);
            this.practiceScore = practiceScore;
            this.onlineScore = onlineScore;
            this.examScore = examScore;
            this.averageScore = Helper.round((25 * practiceScore + 35 * onlineScore + 40 * examScore) / 100, 2);
        }

        public String getCode() {
            return code;
        }

        public double getAverageScore() {
            return averageScore;
        }

        public String getClassification() {
            if (averageScore >= 8) {
                return "GIOI";
            }
            if (averageScore >= 6.5) {
                return "KHA";
            }
            if (averageScore >= 5) {
                return "TRUNG BINH";
            }
            return "KEM";
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f %s", code, name, averageScore, getClassification());
        }
    }

    private static class Helper {
        public static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(word ->
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
            ).collect(Collectors.joining(" "));
        }

        public static double round(double value, int places) {
            if (places < 0) {
                throw new IllegalArgumentException();
            }
            long factor = (long) Math.pow(10, places);
            return (double) Math.round(value * factor) / factor;
        }
    }
}
