package J05024;

public class Student {
    private final String id;
    private final String fullName;
    private final String clazz;
    private final String email;

    public Student(String id, String fullName, String clazz, String email) {
        this.id = id;
        this.fullName = fullName;
        this.clazz = clazz;
        this.email = email;
    }

    public String getMajor() {
        if (id.contains("DCKT")) {
            return "KE TOAN";
        }
        if (!clazz.startsWith("E")) {
            if (id.contains("DCCN")) {
                return "CONG NGHE THONG TIN";
            }
            if (id.contains("DCAT")) {
                return "AN TOAN THONG TIN";
            }
        }
        if (id.contains("DCVT")) {
            return "VIEN THONG";
        }
        if (id.contains("DCDT")) {
            return "DIEN TU";
        }
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, fullName, clazz, email);
    }
}
