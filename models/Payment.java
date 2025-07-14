package com.bankapp.models;

import java.io.Serializable;

public class Payment implements Comparable<Payment>, Serializable {
    private double amount;
    private Card card;

    public Payment(double amount, Card card) {
        this.amount = amount;
        this.card = card;
    }

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    public int compareTo(Payment other) {
        return Double.compare(this.amount, other.amount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", card=" + card +
                '}';
    }
}
