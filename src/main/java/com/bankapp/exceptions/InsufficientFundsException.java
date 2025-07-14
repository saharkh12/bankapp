package com.bankapp.exceptions;

/**
 * Exception thrown when an account has insufficient funds for a transaction.
 */
public class InsufficientFundsException extends Exception {
    private double availableAmount;

    /**
     * Constructs a new InsufficientFundsException with the specified detail message and available amount.
     *
     * @param message the detail message
     * @param availableAmount the amount of funds available in the account
     */
    public InsufficientFundsException(String message, double availableAmount) {
        super(message);
        this.availableAmount = availableAmount;
    }

    /**
     * Gets the amount of funds available in the account.
     *
     * @return the available amount
     */
    public double getAvailableAmount() {
        return availableAmount;
    }
}
