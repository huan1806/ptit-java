package J05005;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id = String.format("B20DCCN%03d", counter.incrementAndGet());
    private String fullName;
    private String clazz;
    private String dob;
    private double gpa;

    public Student() {
    }

    public Student(String fullName, String clazz, String dob, double gpa) {
        this.fullName = Helper.formatName(fullName);
        this.clazz = clazz;
        this.dob = Helper.standardizeDate(dob);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, fullName, clazz, dob, gpa);
    }


}
