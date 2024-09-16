import java.util.Scanner;

public class J04003 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            long numerator = sc.nextLong();
            long denominator = sc.nextLong();
            Fraction fraction = new Fraction(numerator, denominator);
            System.out.println(fraction.reduce());
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

        public Fraction reduce() {
            long gcd = Helper.gcd(numerator, denominator);
            return new Fraction(numerator / gcd, denominator / gcd);
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


