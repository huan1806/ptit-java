package J05042;

public class Student {
    private String name;
    private int correct;
    private int totalSubmit;

    public Student(String name, int correct, int totalSubmit) {
        this.name = name;
        this.correct = correct;
        this.totalSubmit = totalSubmit;
    }

    public String getName() {
        return name;
    }

    public int getCorrect() {
        return correct;
    }

    public int getTotalSubmit() {
        return totalSubmit;
    }

    @Override
    public String toString() {
        return name + " " + correct + " " + totalSubmit;
    }
}
