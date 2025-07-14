package com.bankapp.models;

import com.bankapp.collections.SavingAccountCollection;
import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import java.io.Serializable;

import java.util.Date;

public class CurrentAccount extends Account implements Serializable {
    private double overdraftLimit;
    private SavingAccountCollection linkedSavingsAccounts;

    public CurrentAccount(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled, PaymentCollection payments, TransactionCollection transactions, LoanCollection loans, double overdraftLimit, SavingAccountCollection linkedSavingsAccounts) {
        super(client, balance, RIB, openingDate, closingDate, isDisabled, payments, transactions, loans);
        this.overdraftLimit = overdraftLimit;
        this.linkedSavingsAccounts = linkedSavingsAccounts;
    }

    // Getters and Setters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public SavingAccountCollection getLinkedSavingsAccounts() {
        return linkedSavingsAccounts;
    }

    public void setLinkedSavingsAccounts(SavingAccountCollection linkedSavingsAccounts) {
        this.linkedSavingsAccounts = linkedSavingsAccounts;
    }

    // Methods
    public double getOverdraft() {
        return overdraftLimit;
    }

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
