package com.bankapp.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a card within the bank application.
 */
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number;
    private Date validTo;
    private boolean isActivated;
    private int pinCode;
    private Account account;
    private int CVV;
    private final int maxWithdraw;

    /**
     * Constructs a new Card with the specified details.
     *
     * @param number the card number
     * @param validTo the expiration date of the card
     * @param isActivated whether the card is activated
     * @param pinCode the PIN code of the card
     * @param account the account associated with the card
     * @param CVV the CVV code of the card
     * @param maxWithdraw the maximum withdrawal limit of the card
     */
    public Card(int number, Date validTo, boolean isActivated, int pinCode, Account account, int CVV, int maxWithdraw) {
        this.number = number;
        this.validTo = validTo;
        this.isActivated = isActivated;
        this.pinCode = pinCode;
        this.account = account;
        this.CVV = CVV;
        this.maxWithdraw = maxWithdraw;
    }

    // Getters and Setters

    /**
     * Gets the card number.
     *
     * @return the card number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the card number.
     *
     * @param number the card number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the expiration date of the card.
     *
     * @return the expiration date of the card
     */
    public Date getValidTo() {
        return validTo;
    }

    /**
     * Sets the expiration date of the card.
     *
     * @param validTo the expiration date to set
     */
    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    /**
     * Checks if the card is activated.
     *
     * @return true if the card is activated, false otherwise
     */
    public boolean isActivated() {
        return isActivated;
    }

    /**
     * Sets the activation status of the card.
     *
     * @param activated the activation status to set
     */
    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    /**
     * Gets the PIN code of the card.
     *
     * @return the PIN code of the card
     */
    public int getPinCode() {
        return pinCode;
    }

    /**
     * Sets the PIN code of the card.
     *
     * @param pinCode the PIN code to set
     */
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * Gets the account associated with the card.
     *
     * @return the account associated with the card
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the account associated with the card.
     *
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets the CVV code of the card.
     *
     * @return the CVV code of the card
     */
    public int getCVV() {
        return CVV;
    }

    /**
     * Sets the CVV code of the card.
     *
     * @param CVV the CVV code to set
     */
    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    /**
     * Gets the maximum withdrawal limit of the card.
     *
     * @return the maximum withdrawal limit of the card
     */
    public int getMaxWithdraw() {
        return maxWithdraw;
    }

    // Methods

    /**
     * Activates the card.
     */
    public void activate() {
        this.isActivated = true;
    }

    /**
     * Deactivates the card.
     */
    public void deactivate() {
        this.isActivated = false;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", validTo=" + validTo +
                ", isActivated=" + isActivated +
                ", pinCode=" + pinCode +
                ", account=" + account +
                ", CVV=" + CVV +
                ", maxWithdraw=" + maxWithdraw +
                '}';
    }
}
