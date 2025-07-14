package com.bankapp.models;

import java.io.Serializable;

/**
 * Represents a payment made within the bank application.
 */
public class Payment implements Comparable<Payment>, Serializable {
    private static final long serialVersionUID = 1L;
    private double amount;
    private Card card;

    /**
     * Constructs a new Payment with the specified amount and card.
     *
     * @param amount the amount of the payment
     * @param card the card used for the payment
     */
    public Payment(double amount, Card card) {
        this.amount = amount;
        this.card = card;
    }

    // Getters and Setters

    /**
     * Gets the amount of the payment.
     *
     * @return the amount of the payment
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the card used for the payment.
     *
     * @return the card used for the payment
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the card used for the payment.
     *
     * @param card the card to set
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Compares this payment to another payment based on the amount.
     *
     * @param other the other payment to compare to
     * @return a negative integer, zero, or a positive integer as this payment's amount is less than, equal to, or greater than the other payment's amount
     */
    @Override
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
