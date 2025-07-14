package com.bankapp.exceptions;

/**
 * Exception thrown when an account is not found in the bank application.
 */
public class AccountNotFoundException extends Exception {
    
    /**
     * Constructs a new AccountNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public AccountNotFoundException(String message) {
        super(message);
    }

    /**
     * Provides a recovery message when the exception is thrown.
     */
    public void recover() {
        System.out.println("Recovery: Please check the account details and try again.");
    }
}
