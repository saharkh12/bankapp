package com.bankapp.exceptions;

public class InsufficientFundsException extends Exception {
    private double availableAmount;

    public InsufficientFundsException(String message, double availableAmount) {
        super(message);
        this.availableAmount = availableAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }
}
