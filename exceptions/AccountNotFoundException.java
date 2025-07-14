package com.bankapp.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }

    public void recover() {
        System.out.println("Recovery: Please check the account details and try again.");
    }
}
