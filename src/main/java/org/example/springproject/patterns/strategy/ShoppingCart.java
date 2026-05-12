package org.example.springproject.patterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    private int calculateTotal() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public void checkout() {
        int total = calculateTotal();
        paymentStrategy.pay(total);
    }

}
