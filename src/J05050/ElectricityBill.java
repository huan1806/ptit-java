package J05050;

import java.util.concurrent.atomic.AtomicInteger;

public class ElectricityBill {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id = String.format("KH%02d", counter.incrementAndGet());
    private int coefficient;
    private long amount;
    private long surchargeAmount;
    private long totalAmountToPay;

    public ElectricityBill(String type, long previousIndex, long currentIndex) {
        setCoefficient(type);
        calculateAmounts(previousIndex, currentIndex);
    }

    private void calculateAmounts(long previousIndex, long currentIndex) {
        long using = currentIndex - previousIndex;
        amount = using * coefficient * 550;
        surchargeAmount = (long) Math.ceil(amount * getSurchargeAmountRate(using));
        totalAmountToPay = amount + surchargeAmount;
    }

    private double getSurchargeAmountRate(long using) {
        if (using < 50) {
            return 0;
        }
        return using <= 100 ? 0.35 : 1;
    }

    private void setCoefficient(String type) {
        switch (type) {
            case "CN":
                coefficient = 2;
                break;
            case "KD":
                coefficient = 3;
                break;
            case "TT":
                coefficient = 4;
                break;
            case "NN":
                coefficient = 5;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d", id, coefficient, amount, surchargeAmount, totalAmountToPay);
    }
}
