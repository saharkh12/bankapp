package com.bankapp.models;

import java.io.Serializable;
import java.util.Date;

public class Card implements Serializable {
    private int number;
    private Date validTo;
    private boolean isActivated;
    private int pinCode;
    private Account account;
    private int CVV;
    private final int maxWithdraw;

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
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getMaxWithdraw() {
        return maxWithdraw;
    }

    // Methods
    public void activate() {
        this.isActivated = true;
    }

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
