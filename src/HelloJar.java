import view.InvoiceView;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Student;
import vn.edu.ptit.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class HelloJar {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}

class PaymentController {
    public Invoice getInvoice() {
        try (Scanner sc = new Scanner(System.in)) {
            Student student = getStudent(sc);
            ArrayList<Subject> subjects = getSubjects(sc);
            Rule rule = getRule(sc);
            return createInvoice(rule, student, subjects);
        }
    }

    private static Student getStudent(Scanner sc) {
        String studentCode = sc.nextLine();
        String studentName = sc.nextLine();
        return new Student(studentCode, studentName);
    }

    private static ArrayList<Subject> getSubjects(Scanner sc) {
        int numberOfSubjects = sc.nextInt();
        sc.nextLine();
        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < numberOfSubjects; i++) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            int credit = sc.nextInt();
            sc.nextLine();
            subjects.add(new Subject(name, code, credit));
        }
        return subjects;
    }

    private static Rule getRule(Scanner sc) {
        String ruleCode = sc.nextLine();
        String ruleName = sc.nextLine();
        double creditPrice = sc.nextDouble();
        return new Rule(ruleCode, ruleName, creditPrice);
    }

    private static Invoice createInvoice(Rule rule, Student student, ArrayList<Subject> subjects) {
        Invoice invoice = new Invoice(rule);
        invoice.setSt(student);
        invoice.setAlSubject(subjects);
        int credits = subjects.stream().map(Subject::getCredit).reduce(0, Integer::sum);
        double creditPrice = rule.getCreditPrice();
        invoice.setAmount(credits * creditPrice);
        return invoice;
    }
}
