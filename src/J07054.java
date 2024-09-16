import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07054 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<Transcript> transcripts = getTranscripts();
        transcripts.sort(Comparator.comparing(Transcript::getAverageScore).reversed()
                .thenComparing(Transcript::getCode));
        printTranscripts(transcripts);
    }

    private static List<Transcript> getTranscripts() {
        try (Scanner sc = new Scanner(new File("BANGDIEM.in"))) {
            int n = sc.nextInt();
            List<Transcript> transcripts = new ArrayList<Transcript>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Transcript transcript = new Transcript(sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                transcripts.add(transcript);
            }
            return transcripts;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTranscripts(List<Transcript> transcripts) {
        int rank = 0;
        double previousScore = 0;
        for (int i = 0; i < transcripts.size(); i++) {
            Transcript transcript = transcripts.get(i);
            if (previousScore != transcript.getAverageScore()) {
                rank = i + 1;
            }
            previousScore = transcript.getAverageScore();
            System.out.println(transcript + " " + rank);
        }
    }

    private static class Transcript {
        private static final AtomicInteger counter = new AtomicInteger(1);
        private final String code = String.format("SV%02d", counter.getAndIncrement());
        private String name;
        private double score1;
        private double score2;
        private double score3;
        private double averageScore;

        public Transcript(String name, double score1, double score2, double score3) {
            this.name = Helper.formatName(name);
            this.score1 = score1;
            this.score2 = score2;
            this.score3 = score3;
            this.averageScore = Helper.round((3 * score1 + 3 * score2 + 2 * score3) / 8, 2);
        }

        public String getCode() {
            return code;
        }

        public double getAverageScore() {
            return averageScore;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", code, name, averageScore);
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
