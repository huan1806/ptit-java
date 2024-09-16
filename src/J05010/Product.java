package J05010;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id = counter.incrementAndGet();
    private String name;
    private String group;
    private double purchasePrice;
    private double sellingPrice;

    public Product(String name, String group, double purchasePrice, double sellingPrice) {
        this.name = name;
        this.group = group;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public double getProfit() {
        return sellingPrice - purchasePrice;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.2f", id, name, group, getProfit());
    }
}
