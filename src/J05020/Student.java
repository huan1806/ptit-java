package J05020;

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

    public String getId() {
        return id;
    }

    public String getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", id, fullName, clazz, email);
    }
}
