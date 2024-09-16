package J05006;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private final String id = String.format("%05d", counter.getAndIncrement());
    private String name;
    private String sex;
    private String dob;
    private String address;
    private String taxCode;
    private String contractDate;

    public Employee(String name, String sex, String dob, String address, String taxCode, String contractDate) {
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.contractDate = contractDate;
    }

    // getters and setters are not necessary

    @Override
    public String toString() {
        return id + " " + name + " " + sex + " " + dob + " " + address + " " + taxCode + " " + contractDate;
    }
}
