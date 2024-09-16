import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class J07046 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("KHACH.in"))) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Guest> guests = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Guest guest = new Guest(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine()
                );
                guests.add(guest);
            }
            guests.sort(Comparator.comparing(Guest::getStayDays).reversed());
            guests.forEach(System.out::println);
        }
    }

    private static class Guest {
        private static final AtomicInteger count = new AtomicInteger(1);
        private String code;
        private String name;
        private String roomCode;
        private Date arrivalDate;
        private Date departureDate;

        public Guest(String name, String roomCode, String arrivalDate, String departureDate) {
            this.code = String.format("KH%02d", count.getAndIncrement());
            this.name = name;
            this.roomCode = roomCode;
            this.arrivalDate = strToDate(arrivalDate);
            this.departureDate = strToDate(departureDate);
        }

        public int getStayDays() {
            return (int) ((departureDate.getTime() - arrivalDate.getTime()) / (24 * 60 * 60 * 1000));
        }

        private Date strToDate(String date) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            return code + " " + name + " " + roomCode + " " + getStayDays();
        }
    }
}
