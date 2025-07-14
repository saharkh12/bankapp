package com.bankapp.models;

import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import com.bankapp.exceptions.InsufficientFundsException;
import com.bankapp.exceptions.InvalidDepositException;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a bank account within the bank application.
 */
public class Account implements Comparable<Account>, Serializable {
    private static final long serialVersionUID = 1L;
    private Client client;
    private double balance;
    private int RIB;
    private Date openingDate;
    private Date closingDate;
    private boolean isDisabled;
    private PaymentCollection payments;
    private TransactionCollection transactions;
    private LoanCollection loans;

    /**
     * Constructs a new Account with the specified details.
     *
     * @param client the client who owns the account
     * @param balance the initial balance of the account
     * @param RIB the unique identifier for the account
     * @param openingDate the date the account was opened
     * @param closingDate the date the account will be closed
     * @param isDisabled whether the account is disabled
     * @param payments the collection of payments associated with the account
     * @param transactions the collection of transactions associated with the account
     * @param loans the collection of loans associated with the account
     */
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

    /**
     * Constructs a new Account with the specified details, without payment, transaction, and loan collections.
     *
     * @param client the client who owns the account
     * @param balance the initial balance of the account
     * @param RIB the unique identifier for the account
     * @param openingDate the date the account was opened
     * @param closingDate the date the account will be closed
     * @param isDisabled whether the account is disabled
     */
    public Account(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled) {
        this.client = client;
        this.balance = balance;
        this.RIB = RIB;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.isDisabled = isDisabled;
    }

    // Getters and Setters

    /**
     * Gets the client who owns the account.
     *
     * @return the client who owns the account
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client who owns the account.
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets the balance of the account.
     *
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Gets the unique identifier for the account.
     *
     * @return the RIB of the account
     */
    public int getRIB() {
        return RIB;
    }

    /**
     * Sets the unique identifier for the account.
     *
     * @param RIB the RIB to set
     */
    public void setRIB(int RIB) {
        this.RIB = RIB;
    }

    /**
     * Gets the date the account was opened.
     *
     * @return the opening date of the account
     */
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * Sets the date the account was opened.
     *
     * @param openingDate the opening date to set
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     * Gets the date the account will be closed.
     *
     * @return the closing date of the account
     */
    public Date getClosingDate() {
        return closingDate;
    }

    /**
     * Sets the date the account will be closed.
     *
     * @param closingDate the closing date to set
     */
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * Checks if the account is disabled.
     *
     * @return true if the account is disabled, false otherwise
     */
    public boolean isDisabled() {
        return isDisabled;
    }

    /**
     * Sets the disabled status of the account.
     *
     * @param disabled the disabled status to set
     */
    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    /**
     * Gets the collection of payments associated with the account.
     *
     * @return the payment collection
     */
    public PaymentCollection getPayments() {
        return payments;
    }

    /**
     * Sets the collection of payments associated with the account.
     *
     * @param payments the payment collection to set
     */
    public void setPayments(PaymentCollection payments) {
        this.payments = payments;
    }

    /**
     * Gets the collection of transactions associated with the account.
     *
     * @return the transaction collection
     */
    public TransactionCollection getTransactions() {
        return transactions;
    }

    /**
     * Sets the collection of transactions associated with the account.
     *
     * @param transactions the transaction collection to set
     */
    public void setTransactions(TransactionCollection transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets the collection of loans associated with the account.
     *
     * @return the loan collection
     */
    public LoanCollection getLoans() {
        return loans;
    }

    /**
     * Sets the collection of loans associated with the account.
     *
     * @param loans the loan collection to set
     */
    public void setLoans(LoanCollection loans) {
        this.loans = loans;
    }

    // Methods

    /**
     * Disables the account if it is not already disabled.
     *
     * @return true if the account was successfully disabled, false otherwise
     */
    public boolean toDisable() {
        if (!isDisabled) {
            this.isDisabled = true;
            return true;
        }
        return false;
    }

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit
     * @return true if the deposit was successful, false otherwise
     * @throws InvalidDepositException if the deposit amount is not positive
     */
    public boolean deposit(double amount) throws InvalidDepositException {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            throw new InvalidDepositException("Deposit amount must be positive.");
        }
    }

    /**
     * Displays the transaction history of the account.
     */
    public void displayHistory() {
        System.out.println(transactions.toString());
    }

    /**
     * Gets the collection of loans associated with the account.
     *
     * @return the loan collection
     */
    public LoanCollection getLoan() {
        return loans;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     * @throws InsufficientFundsException if the withdrawal amount is greater than the balance or not positive
     */
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

    /**
     * Compares this account to another account based on the RIB.
     *
     * @param other the other account to compare to
     * @return a negative integer, zero, or a positive integer as this account's RIB is less than, equal to, or greater than the other account's RIB
     */
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
