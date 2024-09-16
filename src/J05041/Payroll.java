package J05041;

public class Payroll {
    private Employee employee;
    private long dailyPaid;
    private long workingDays;
    private long monthlyPaid;
    private long bonus;
    private long allowance;
    private long grossSalary;

    public Payroll(Employee employee, long dailyPaid, long workingDays) {
        this.employee = employee;
        this.dailyPaid = dailyPaid;
        this.workingDays = workingDays;
        this.monthlyPaid = dailyPaid * workingDays;
        this.bonus = calculateBonus();
        this.allowance = calculateAllowance();
        this.grossSalary = this.monthlyPaid + this.bonus + this.allowance;
    }

    public long getGrossSalary() {
        return grossSalary;
    }

    private long calculateBonus() {
        if (workingDays >= 25) {
            return (long) (0.2 * monthlyPaid);
        }
        if (workingDays >= 22) {
            return  (long) (0.1 * monthlyPaid);
        }
        return 0;
    }

    private long calculateAllowance() {
        String position = employee.getPosition();
        if (position == null) {
            return 0;
        }
        switch (position) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            case "NV":
                return 150000;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return employee + " " + monthlyPaid + " " + bonus + " " + allowance + " " + grossSalary;
    }
}
