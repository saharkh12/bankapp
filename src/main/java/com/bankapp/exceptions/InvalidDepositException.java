package com.bankapp.exceptions;

/**
 * Exception thrown when an invalid deposit amount is specified.
 */
public class InvalidDepositException extends Exception {
    
    /**
     * Constructs a new InvalidDepositException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidDepositException(String message) {
        super(message);
    }
}
