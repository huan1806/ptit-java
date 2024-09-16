package J05052;

public class Item {
    private String itemName;
    private String code;
    private long price;
    private long quantity;
    private long amount;
    private long discountAmount;
    private long amountToPay;

    public Item(String itemName, String code, long price, long quantity) {
        this.itemName = itemName;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
        this.amount = quantity * price;
        this.calculateDiscountAmount();
        amountToPay = amount - discountAmount;
    }

    private void calculateDiscountAmount() {
        this.discountAmount = Math.round(amount * getDiscountRate());
    }

    private double getDiscountRate() {
        return code.charAt(4) != '1' ? 0.3 : 0.5;
    }

    private String getOrderNumber() {
        return code.substring(1, 4);
    }

    @Override
    public String toString() {
        return itemName + " " + code + " " + getOrderNumber() + " " + discountAmount + " " + amountToPay;
    }
}
