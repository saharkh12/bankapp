package com.bankapp.models;

import java.util.Date;

import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.collections.LoanCollection;
import com.bankapp.exceptions.InsufficientFundsException;
import com.bankapp.exceptions.InvalidDepositException;
import java.io.Serializable;

/**
 * Represents a savings account within the bank application.
 */
public class SavingAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private double interestRate;
    private CurrentAccount currentAccount;
    private double monthlyDeposit;

    /**
     * Constructs a new SavingAccount with the specified details.
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
     * @param interestRate the interest rate applied to the account
     * @param currentAccount the current account linked to this savings account
     * @param monthlyDeposit the required monthly deposit for the account
     */
    public SavingAccount(Client client, double balance, int RIB, Date openingDate, Date closingDate, boolean isDisabled, PaymentCollection payments, TransactionCollection transactions, LoanCollection loans, double interestRate, CurrentAccount currentAccount, double monthlyDeposit) {
        super(client, balance, RIB, openingDate, closingDate, isDisabled, payments, transactions, loans);
        this.interestRate = interestRate;
        this.currentAccount = currentAccount;
        this.monthlyDeposit = monthlyDeposit;
    }

    // Getters and Setters

    /**
     * Gets the interest rate applied to the account.
     *
     * @return the interest rate of the account
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate applied to the account.
     *
     * @param interestRate the interest rate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Gets the current account linked to this savings account.
     *
     * @return the linked current account
     */
    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    /**
     * Sets the current account linked to this savings account.
     *
     * @param currentAccount the current account to set
     */
    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    /**
     * Gets the required monthly deposit for the account.
     *
     * @return the monthly deposit amount
     */
    public double getMonthlyDeposit() {
        return monthlyDeposit;
    }

    /**
     * Sets the required monthly deposit for the account.
     *
     * @param monthlyDeposit the monthly deposit amount to set
     */
    public void setMonthlyDeposit(double monthlyDeposit) {
        this.monthlyDeposit = monthlyDeposit;
    }

    // Methods

    /**
     * Applies the interest to the account balance.
     *
     * @throws InvalidDepositException if the deposit amount is invalid
     */
    public void applyInterest() throws InvalidDepositException {
        double interest = this.getBalance() * (interestRate / 100);
        this.deposit(interest);
    }

    /**
     * Transfers a specified amount from this savings account to the linked current account.
     *
     * @param amount the amount to transfer
     * @throws InsufficientFundsException if there are insufficient funds for the transfer
     * @throws InvalidDepositException if the deposit amount is invalid
     */
    public void transfer(double amount) throws InsufficientFundsException, InvalidDepositException {
        if (this.withdraw(amount)) {
            currentAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    /**
     * Compares this savings account to another based on the balance.
     *
     * @param other the other savings account to compare to
     * @return a negative integer, zero, or a positive integer as this account's balance is less than, equal to, or greater than the other account's balance
     */
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
