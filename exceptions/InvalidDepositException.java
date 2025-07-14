package com.bankapp.exceptions;

public class InvalidDepositException extends Exception {
    public InvalidDepositException(String message) {
        super(message);
    }
}
