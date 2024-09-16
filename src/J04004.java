import java.util.Scanner;

public class J04004 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            Fraction fraction1 = new Fraction(sc.nextLong(), sc.nextLong());
            Fraction fraction2 = new Fraction(sc.nextLong(), sc.nextLong());
            System.out.println(fraction1.add(fraction2));
        }
    }

    private static class Fraction {
        private long numerator;
        private long denominator;

        public Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public long getNumerator() {
            return numerator;
        }

        public void setNumerator(long numerator) {
            this.numerator = numerator;
        }

        public long getDenominator() {
            return denominator;
        }

        public void setDenominator(long denominator) {
            this.denominator = denominator;
        }

        public Fraction add(Fraction f) {
            numerator = numerator * f.getDenominator() + f.getNumerator() * denominator;
            denominator = denominator * f.getDenominator();
            return reduce();
        }

        public Fraction reduce() {
            long gcd = Helper.gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            return this;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    private static class Helper {
        public static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}


