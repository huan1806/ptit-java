import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class J07084 {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        List<OnlineTime> onlineTimes = getOnlineTimes();
        onlineTimes.sort(Comparator.comparing(OnlineTime::getOnlineTime).reversed()
                .thenComparing(OnlineTime::getName));
        onlineTimes.forEach(System.out::println);
    }

    private static List<OnlineTime> getOnlineTimes() {
        try (Scanner sc = new Scanner(new File("ONLINE.in"))) {
            int n = sc.nextInt();
            sc.nextLine();
            List<OnlineTime> onlineTimes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                OnlineTime onlineTime = new OnlineTime(sc.nextLine(), sc.nextLine(), sc.nextLine());
                onlineTimes.add(onlineTime);
            }
            return onlineTimes;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static class OnlineTime {
        private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        private String name;
        private Date startTime;
        private Date endTime;
        private long onlineTime;

        public OnlineTime(String name, String startTime, String endTime) {
            this.name = name;
            try {
                this.startTime = sdf.parse(startTime);
                this.endTime = sdf.parse(endTime);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.onlineTime = this.endTime.getTime() - this.startTime.getTime();
        }

        public String getName() {
            return name;
        }

        public long getOnlineTime() {
            return onlineTime;
        }

        @Override
        public String toString() {
            return name + " " + onlineTime / (60 * 1000);
        }
    }
}
