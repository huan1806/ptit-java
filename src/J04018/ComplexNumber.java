package J04018;

public class ComplexNumber {
    private int real;
    private int imag;

    public ComplexNumber(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber(ComplexNumber c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(this.real + c.real, this.imag + c.imag);
    }

    public ComplexNumber multiply(ComplexNumber c) {
        return new ComplexNumber(this.real * c.real - this.imag * c.imag, this.real * c.imag + this.imag * c.real);
    }

    @Override
    public String toString() {
        if (imag >= 0) {
            return String.format("%d + %di", real, imag);
        }
        return String.format("%d - %di", real, -imag);
    }
}
