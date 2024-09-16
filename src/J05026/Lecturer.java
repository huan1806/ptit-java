package J05026;

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

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + Helper.getAbbreviation(department);
    }
}
