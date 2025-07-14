
package com.bankapp.models;

import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import com.bankapp.exceptions.InsufficientFundsException;
import com.bankapp.exceptions.InvalidDepositException;
import java.io.Serializable;

import java.util.Date;

public class Account implements Comparable<Account>, Serializable{
    private Client client;
    private double balance;
    private int RIB;
    private Date openingDate;
    private Date closingDate;
    private boolean isDisabled;
    private PaymentCollection payments;
    private TransactionCollection transactions;
    private LoanCollection loans;

    public Account(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled, PaymentCollection payments, TransactionCollection transactions, LoanCollection loans) {
        this.client = client;
        this.balance = balance;
        this.RIB = RIB;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.isDisabled = isDisabled;
        this.payments = payments;
        this.transactions = transactions;
        this.loans = loans;
    }

    public Account(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled) {
        this.client = client;
        this.balance = balance;
        this.RIB = RIB;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.isDisabled = isDisabled;
    }

    // Getters and Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getRIB() {
        return RIB;
    }

    public void setRIB(int RIB) {
        this.RIB = RIB;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public PaymentCollection getPayments() {
        return payments;
    }

    public void setPayments(PaymentCollection payments) {
        this.payments = payments;
    }

    public TransactionCollection getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionCollection transactions) {
        this.transactions = transactions;
    }

    public LoanCollection getLoans() {
        return loans;
    }

    public void setLoans(LoanCollection loans) {
        this.loans = loans;
    }

    // Methods
    public boolean toDisable() {
        if (!isDisabled) {
            this.isDisabled = true;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) throws InvalidDepositException {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            throw new InvalidDepositException("Deposit amount must be positive.");
        }
    }

    public void displayHistory() {
        System.out.println(transactions.toString());
    }

    public LoanCollection getLoan() {
        return loans;
    }

    public boolean withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else if (amount <= 0) {
            throw new InsufficientFundsException("Withdraw amount must be positive.", balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds. Available amount: " + balance, balance);
        }
    }

    @Override
    public int compareTo(Account other) {
        return Integer.compare(this.RIB, other.RIB);
    }

    @Override

    public String toString() {
        return "Account{" +
            "client=" + client.getClientID() + 
            ", balance=" + balance +
            ", RIB=" + RIB +
            ", openingDate=" + openingDate +
            '}';
    }
}
