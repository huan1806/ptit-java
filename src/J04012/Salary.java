package J04012;

public class Salary {
    private final int baseSalary;
    private final int bonus;
    private final int allowance;
    private final int grossSalary;

    public Salary(Employee employee) {
        int numberOfWorkingDays = employee.getNumberOfWorkingDays();
        baseSalary = employee.getDailyBaseSalary() * numberOfWorkingDays;
        if (numberOfWorkingDays >= 25) {
            bonus = 2 * baseSalary / 10;
        } else if (numberOfWorkingDays >= 22) {
            bonus = baseSalary / 10;
        } else {
            bonus = 0;
        }
        allowance = getAllowanceByPosition(employee.getPosition());
        grossSalary = baseSalary + bonus + allowance;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public int getAllowance() {
        return allowance;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    @Override
    public String toString() {
        return baseSalary + " " + bonus + " " + allowance + " " + grossSalary;
    }

    private int getAllowanceByPosition(Position position) {
        switch (position) {
            case GD:
                return 250_000;
            case PGD:
                return 200_000;
            case TP:
                return 180_000;
            case NV:
                return 150_000;
            default:
                return 0;
        }
    }
}
