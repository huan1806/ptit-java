package J05011;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Account {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    private final String id;
    private final String name;
    private final LocalTime lastLoginTime;
    private final LocalTime lastLogoutTime;

    public Account(String id, String name, String lastLoginTime, String lastLogoutTime) {
        this.id = id;
        this.name = name;
        this.lastLoginTime = LocalTime.parse(lastLoginTime, dtf);
        this.lastLogoutTime = LocalTime.parse(lastLogoutTime, dtf);
    }

    public long getPlayingTimeInMinutes() {
        return lastLoginTime.until(lastLogoutTime, ChronoUnit.MINUTES);
    }

    @Override
    public String toString() {
        long playingTimeInMinutes = getPlayingTimeInMinutes();
        long hours = playingTimeInMinutes / 60;
        long minutes = playingTimeInMinutes % 60;
        return String.format("%s %s %d gio %d phut", id, name, hours, minutes);
    }
}
