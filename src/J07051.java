import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class J07051 {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    private static void solve() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("KHACHHANG.in"))) {
            int n = sc.nextInt();
            List<Guest> guests = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
                Guest guest = new Guest(
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        sc.nextInt()
                );
                guests.add(guest);
            }
            guests.sort(Comparator.comparing(Guest::getAmountToPay).reversed());
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
        private int serviceFee;

        public Guest(String name, String roomCode, String arrivalDate, String departureDate, int serviceFee) {
            this.code = String.format("KH%02d", count.getAndIncrement());
            this.name = formatName(name);
            this.roomCode = roomCode;
            this.arrivalDate = strToDate(arrivalDate);
            this.departureDate = strToDate(departureDate);
            this.serviceFee = serviceFee;
        }

        public int getStayDays() {
            return (int) ((departureDate.getTime() - arrivalDate.getTime()) / (24 * 60 * 60 * 1000)) + 1;
        }

        public int getAmountToPay() {
            final int[] priceByFloor = new int[]{25, 34, 50, 80};
            int floor = roomCode.charAt(0) - '0';
            return priceByFloor[floor - 1] * getStayDays() + serviceFee;
        }

        private Date strToDate(String date) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        private static String formatName(String name) {
            String[] words = name.trim().split("\\s+");
            return Arrays.stream(words).map(Guest::capitalize).collect(Collectors.joining(" "));
        }

        private static String capitalize(String s) {
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        }

        @Override
        public String toString() {
            return code + " " + name + " " + roomCode + " " + getStayDays() + " " + getAmountToPay();
        }
    }
}
