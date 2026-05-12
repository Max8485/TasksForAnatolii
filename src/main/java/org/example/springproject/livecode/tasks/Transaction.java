package org.example.springproject.livecode.tasks;

public class Transaction {
    Type type;
    double amount;
    String date;

    public Transaction(Type type, double amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
