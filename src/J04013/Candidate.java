package J04013;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Candidate {
    private static final int benchmarkScore = 24;
    private String code;
    private String name;
    private double mathScore;
    private double physicScore;
    private double chemistryScore;
    private double totalScore;
    private String status;

    public Candidate(String code, String name, double mathScore, double physicScore, double chemistryScore) {
        this.code = code;
        this.name = formatName(name);
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
        this.totalScore = calculateScore();
        if (totalScore >= benchmarkScore) {
            this.status = "TRUNG TUYEN";
        } else {
            this.status = "TRUOT";
        }
    }

    public String getCode() {
        return code;
    }

    public double getTotalScore() {
        return totalScore;
    }

    private String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        return Arrays.stream(words).map(word ->
                word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()
        ).collect(Collectors.joining(" "));
    }

    private double calculateScore() {
        return 2 * mathScore + physicScore + chemistryScore + getPriorityPoint();
    }

    private double getPriorityPoint() {
        char region = code.charAt(2);
        switch (region) {
            case '1':
                return 0.5;
            case '2':
                return 1;
            case '3':
                return 2.5;
            default:
                return 0;
        }
    }

    private String doubleToString(double d) {
        if (d == (int) d) {
            return String.valueOf((int) d);
        }
        return String.format("%.1f", d);
    }

    @Override
    public String toString() {
        double priorityPoint = getPriorityPoint();
        return String.format("%s %s %s %s %s", code, name, doubleToString(priorityPoint),
                doubleToString(getTotalScore() - priorityPoint), status);
    }
}
