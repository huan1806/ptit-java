package J05041;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id = String.format("NV%02d", counter.incrementAndGet());
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
