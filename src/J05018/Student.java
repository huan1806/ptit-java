package J05018;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id = String.format("HS%02d", counter.incrementAndGet());
    private final String name;
    private final double[] scores;
    private final double gpa;

    public Student(String name, double[] scores) {
        this.name = name;
        this.scores = scores;
        this.gpa = calculateGPA();
    }

    public double getGpa() {
        return gpa;
    }

    public String getClassification() {
        if (gpa >= 9) {
            return "XUAT SAC";
        }
        if (gpa >= 8) {
            return "GIOI";
        }
        if (gpa >= 7) {
            return "KHA";
        }
        if (gpa >= 5) {
            return "TB";
        }
        return "YEU";
    }

    private double calculateGPA() {
        double sum = 2 * (scores[0] + scores[1]);
        for (int i = 2; i < scores.length; i++) {
            sum += scores[i];
        }
        return round(sum / 12, 1);
    }

    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        double factor = Math.pow(10, places);
        return Math.round(value * factor) / factor;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", id, name, gpa, getClassification());
    }
}
