package com.bankapp.models;

import com.bankapp.exceptions.InsufficientFundsException;
import java.io.Serializable;

public class ATM implements Serializable {
    private int atmId;
    private String location;
    private double cashAvailable;

    public ATM(int atmId, String location, double cashAvailable) {
        this.atmId = atmId;
        this.location = location;
        this.cashAvailable = cashAvailable;
    }

    // Getters and Setters
    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    // Methods
    public double checkBalance(Card card) {
        return card.getAccount().getBalance();
    }

    public boolean withdraw(Card card, double amount) throws InsufficientFundsException {
        if (card.isActivated() && card.getAccount().getBalance() >= amount && this.cashAvailable >= amount) {
            if (card.getAccount().withdraw(amount)) {
                this.cashAvailable -= amount;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atmId=" + atmId +
                ", location='" + location + '\'' +
                ", cashAvailable=" + cashAvailable +
                '}';
    }
}
