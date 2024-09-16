import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class J07059 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<ExamSession> examSessions = getExamSessions();
        examSessions.sort(Comparator.comparing(ExamSession::getDate).thenComparing(ExamSession::getTime)
                .thenComparing(ExamSession::getCode));
        examSessions.forEach(System.out::println);
    }

    private static List<ExamSession> getExamSessions() {
        try (Scanner sc = new Scanner(new File("CATHI.in"))) {
            int n = sc.nextInt();
            List<ExamSession> examSessions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                ExamSession examSession = new ExamSession(sc.nextLine(), sc.nextLine(), sc.nextLong());
                examSessions.add(examSession);
            }
            return examSessions;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class ExamSession {

        private static final AtomicInteger counter = new AtomicInteger();
        private final String code = String.format("C%03d", counter.incrementAndGet());
        private String date;
        private String time;
        private long roomId;

        public ExamSession(String date, String time, long roomId) {
            this.date = date;
            this.time = time;
            this.roomId = roomId;
        }

        public String getCode() {
            return code;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return code + " " + date + " " + time + " " + roomId;
        }
    }
}
