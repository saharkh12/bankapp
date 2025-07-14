package com.bankapp.models;

import java.util.Date;

import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import com.bankapp.exceptions.InsufficientFundsException;
import com.bankapp.exceptions.InvalidDepositException;
import java.io.Serializable;

public class SavingAccount extends Account implements Serializable{
    private double interestRate;
    private CurrentAccount currentAccount;
    private double monthlyDeposit;

    public SavingAccount(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled, PaymentCollection payments, TransactionCollection transactions, LoanCollection loans, double interestRate, CurrentAccount currentAccount, double monthlyDeposit) {
        super(client, balance, RIB, openingDate, closingDate, isDisabled, payments, transactions, loans);
        this.interestRate = interestRate;
        this.currentAccount = currentAccount;
        this.monthlyDeposit = monthlyDeposit;
    }

    // Getters and Setters
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public double getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public void setMonthlyDeposit(double monthlyDeposit) {
        this.monthlyDeposit = monthlyDeposit;
    }

    // Methods
    public void applyInterest() throws InvalidDepositException {
        double interest = this.getBalance() * (interestRate / 100);
        this.deposit(interest);
    }

    public void transfer(double amount) throws InsufficientFundsException, InvalidDepositException {
        if (this.withdraw(amount)) {
            currentAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
    
    public int compareTo(SavingAccount other) {
        return Double.compare(this.getBalance(), other.getBalance());
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "interestRate=" + interestRate +
                ", currentAccount=" + currentAccount +
                ", monthlyDeposit=" + monthlyDeposit +
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
