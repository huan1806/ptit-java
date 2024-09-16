package J05049;

public class Product {

    private String code;
    private long importQuantity;
    private long exportQuantity;
    private long unitPrice;
    private long totalPrice;
    private long tax;

    public Product(String code, long importQuantity) {
        this.code = code;
        this.importQuantity = importQuantity;
        calculateExportQuantity();
        calculateUnitPrice();
        calculateTotalPrice();
        calculateTax();
    }

    public String getCode() {
        return code;
    }

    public long getTax() {
        return tax;
    }

    private void calculateExportQuantity() {
        char firstChar = code.charAt(0);
        exportQuantity = Math.round(importQuantity * (firstChar == 'A' ? 0.6 : 0.7));
    }

    private void calculateUnitPrice() {
        char lastChar = code.charAt(code.length() - 1);
        unitPrice = lastChar == 'Y' ? 110000 : 135000;
    }

    private void calculateTotalPrice() {
        totalPrice = unitPrice * exportQuantity;
    }

    private void calculateTax() {
        char firstChar = code.charAt(0);
        char lastChar = code.charAt(code.length() - 1);
        double taxPercentage;
        if (firstChar == 'A') {
            taxPercentage = lastChar == 'Y' ? 0.08 : 0.11;
        } else {
            taxPercentage = lastChar == 'Y' ? 0.17 : 0.22;
        }
        tax = Math.round(taxPercentage * totalPrice);
    }

    @Override
    public String toString() {
        return code + " " + importQuantity + " " + exportQuantity + " " + unitPrice + " " + totalPrice + " " + tax;
    }
}