package com.bankapp.models;

import com.bankapp.collections.SavingAccountCollection;
import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a current account within the bank application.
 */
public class CurrentAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private double overdraftLimit;
    private SavingAccountCollection linkedSavingsAccounts;

    /**
     * Constructs a new CurrentAccount with the specified details.
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
     * @param overdraftLimit the overdraft limit for the account
     * @param linkedSavingsAccounts the collection of savings accounts linked to this current account
     */
    public CurrentAccount(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled, PaymentCollection payments, TransactionCollection transactions, LoanCollection loans, double overdraftLimit, SavingAccountCollection linkedSavingsAccounts) {
        super(client, balance, RIB, openingDate, closingDate, isDisabled, payments, transactions, loans);
        this.overdraftLimit = overdraftLimit;
        this.linkedSavingsAccounts = linkedSavingsAccounts;
    }

    // Getters and Setters

    /**
     * Gets the overdraft limit for the account.
     *
     * @return the overdraft limit of the account
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets the overdraft limit for the account.
     *
     * @param overdraftLimit the overdraft limit to set
     */
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Gets the collection of savings accounts linked to this current account.
     *
     * @return the linked savings accounts collection
     */
    public SavingAccountCollection getLinkedSavingsAccounts() {
        return linkedSavingsAccounts;
    }

    /**
     * Sets the collection of savings accounts linked to this current account.
     *
     * @param linkedSavingsAccounts the linked savings accounts collection to set
     */
    public void setLinkedSavingsAccounts(SavingAccountCollection linkedSavingsAccounts) {
        this.linkedSavingsAccounts = linkedSavingsAccounts;
    }

    // Methods

    /**
     * Gets the overdraft limit for the account.
     *
     * @return the overdraft limit of the account
     */
    public double getOverdraft() {
        return overdraftLimit;
    }

    /**
     * Sets the overdraft limit for the account.
     *
     * @param overdraftLimit the overdraft limit to set
     */
    public void setOverdraft(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "overdraftLimit=" + overdraftLimit +
                ", linkedSavingsAccounts=" + linkedSavingsAccounts +
                ", balance=" + getBalance() +
                ", RIB=" + getRIB() +
                ", openingDate=" + getOpeningDate() +
                ", closingDate=" + getClosingDate() +
                ", isDisabled=" + isDisabled() +
                ", payments=" + getPayments() +
                ", transactions=" + getTransactions() +
                ", loans=" + getLoans() +
                '}';
    }
}
