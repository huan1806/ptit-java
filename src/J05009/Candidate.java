package J05009;

import java.util.concurrent.atomic.AtomicInteger;

public class Candidate {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id = counter.incrementAndGet();
    private String name;
    private String dob;
    private double score1;
    private double score2;
    private double score3;

    public Candidate(String name, String dob, double score1, double score2, double score3) {
        this.name = name;
        this.dob = dob;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public double getTotalScore() {
        return score1 + score2 + score3;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.1f", id, name, dob, getTotalScore());
    }
}
