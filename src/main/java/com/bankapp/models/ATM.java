package com.bankapp.models;

import com.bankapp.exceptions.InsufficientFundsException;
import java.io.Serializable;

/**
 * Represents an ATM within the bank application.
 */
public class ATM implements Serializable {
    private static final long serialVersionUID = 1L;
    private int atmId;
    private String location;
    private double cashAvailable;

    /**
     * Constructs a new ATM with the specified details.
     *
     * @param atmId the unique identifier of the ATM
     * @param location the location of the ATM
     * @param cashAvailable the amount of cash available in the ATM
     */
    public ATM(int atmId, String location, double cashAvailable) {
        this.atmId = atmId;
        this.location = location;
        this.cashAvailable = cashAvailable;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the ATM.
     *
     * @return the ATM ID
     */
    public int getAtmId() {
        return atmId;
    }

    /**
     * Sets the unique identifier of the ATM.
     *
     * @param atmId the ATM ID to set
     */
    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    /**
     * Gets the location of the ATM.
     *
     * @return the location of the ATM
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the ATM.
     *
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the amount of cash available in the ATM.
     *
     * @return the amount of cash available
     */
    public double getCashAvailable() {
        return cashAvailable;
    }

    /**
     * Sets the amount of cash available in the ATM.
     *
     * @param cashAvailable the amount of cash to set
     */
    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    // Methods

    /**
     * Checks the balance of the account associated with the given card.
     *
     * @param card the card to check balance for
     * @return the balance of the associated account
     */
    public double checkBalance(Card card) {
        return card.getAccount().getBalance();
    }

    /**
     * Withdraws a specified amount from the account associated with the given card.
     *
     * @param card the card to withdraw from
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     * @throws InsufficientFundsException if there are insufficient funds in the account or the ATM
     */
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
