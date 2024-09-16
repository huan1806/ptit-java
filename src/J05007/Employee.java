package J05007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final AtomicInteger counter = new AtomicInteger(1);
    private final String id = String.format("%05d", counter.getAndIncrement());
    private String name;
    private String sex;
    private Date dob;
    private String address;
    private String taxCode;
    private Date contractDate;

    public Employee(String name, String sex, String dob, String address, String taxCode, String contractDate) {
        try {
            this.name = name;
            this.sex = sex;
            this.dob = sdf.parse(dob);
            this.address = address;
            this.taxCode = taxCode;
            this.contractDate = sdf.parse(contractDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + sex + " " + sdf.format(dob) + " " + address + " " + taxCode + " " + sdf.format(contractDate);
    }
}
