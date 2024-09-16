package J05046;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Item {
    private static final ConcurrentMap<String, Integer> counter = new ConcurrentHashMap<>();
    private String code;
    private String name;
    private long quantity;
    private long unitPrice;
    private long discount;
    private long amountToPay;

    public Item(String name, long quantity, long unitPrice) {
        this.name = name;
        this.code = generateCode();
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = Math.round(unitPrice * quantity * getDiscountPercentage());
        this.amountToPay = quantity * unitPrice - this.discount;
    }

    private String generateCode() {
        String[] fragments = name.split("\\s+");
        if (fragments.length < 2) {
            throw new RuntimeException("Invalid item name");
        }
        String abbreviation = String.valueOf(fragments[0].charAt(0)) + fragments[1].charAt(0);
        String code = abbreviation.toUpperCase();
        int count = counter.merge(code, 1, Integer::sum);
        return String.format("%s%02d", code, count);
    }

    private double getDiscountPercentage() {
        if (quantity > 10) {
            return 0.05;
        }
        if (quantity >= 8) {
            return 0.02;
        }
        if (quantity >= 5) {
            return 0.01;
        }
        return 0;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + discount + " " + amountToPay;
    }
}
