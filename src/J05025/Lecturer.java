package J05025;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecturer {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id = String.format("GV%02d", counter.incrementAndGet());
    private final String name;
    private final String department;

    public Lecturer(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getGivenName() {
        String[] words = name.split(" ");
        return words[words.length - 1];
    }

    public String getDepartmentAbbreviation() {
        String[] words = department.split(" ");
        return Arrays.stream(words).map(word -> word.substring(0, 1).toUpperCase())
                .reduce("", String::concat);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getDepartmentAbbreviation();
    }
}
