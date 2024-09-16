package J04014;

public class Fraction {
    private long numerator;
    private long denominator;

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Fraction fraction) {
        this.numerator = fraction.numerator;
        this.denominator = fraction.denominator;
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

    public Fraction add(Fraction other) {
        this.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    public Fraction multiply(Fraction other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return reduce();
    }

    public Fraction square() {
        this.numerator *= this.numerator;
        this.denominator *= this.denominator;
        return reduce();
    }

    public Fraction reduce() {
        long gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
