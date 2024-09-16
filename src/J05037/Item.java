package J05037;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String code = String.format("MH%02d", counter.incrementAndGet());
    private final String name;
    private final String unit;
    private final double price;
    private final double quantity;
    private final double shipmentFee;
    private final double totalPrice;
    private final double sellingPrice;

    public Item(String name, String unit, double price, double quantity) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.shipmentFee = quantity * price * 5 / 100;
        this.totalPrice = quantity * price * 105 / 100;
        this.sellingPrice = price * 1.071;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.0f %.0f %d", code, name, unit, shipmentFee, totalPrice,
                roundToHundredths(sellingPrice));
    }

    private long roundToHundredths(double value) {
        long rounded = (long) (value / 100) * 100;
        return rounded == value ? rounded : rounded + 100;
    }
}
