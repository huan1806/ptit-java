package J04012;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

    private static final AtomicInteger counter = new AtomicInteger(1);
    private final String code = String.format("NV%02d", counter.getAndIncrement());
    private String name;
    private int dailyBaseSalary;
    private int numberOfWorkingDays;
    private Position position;
    private final Salary salary;

    public Employee(String name, int dailyBaseSalary, int numberOfWorkingDays, Position position) {
        this.name = name;
        this.dailyBaseSalary = dailyBaseSalary;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.position = position;
        this.salary = new Salary(this);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDailyBaseSalary() {
        return dailyBaseSalary;
    }

    public void setDailyBaseSalary(int dailyBaseSalary) {
        this.dailyBaseSalary = dailyBaseSalary;
    }

    public int getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(int numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + salary;
    }
}
