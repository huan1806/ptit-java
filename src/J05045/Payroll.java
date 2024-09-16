package J05045;

public class Payroll {
    private Employee employee;
    private long dailyPaid;
    private long workingDays;
    private long basicSalary;
    private long allowance;
    private long salaryAdvance;
    private long remainingSalary;

    public Payroll(Employee employee, long dailyPaid, long workingDays) {
        this.employee = employee;
        this.dailyPaid = dailyPaid;
        this.workingDays = workingDays;
        this.basicSalary = dailyPaid * workingDays;
        this.allowance = calculateAllowance();
        this.salaryAdvance = calculateAdvanceSalary();
        this.remainingSalary = this.basicSalary + this.allowance - this.salaryAdvance;
    }

    public long getSalary() {
        return basicSalary + allowance;
    }

    @Override
    public String toString() {
        return employee + " " + allowance + " " + basicSalary + " " + salaryAdvance + " " + remainingSalary;
    }

    private long calculateAdvanceSalary() {
        return Math.min(roundToThousandth(2.0 * (allowance + basicSalary) / 3), 25000);
    }

    private long calculateAllowance() {
        String position = employee.getPosition();
        if (position == null) {
            return 0;
        }
        switch (position) {
            case "GD":
                return 500;
            case "PGD":
                return 400;
            case "TP":
                return 300;
            case "KT":
                return 250;
            default:
                return 100;
        }
    }

    private long roundToThousandth(double value) {
        return Math.round(value / 1000) * 1000;
    }
}
