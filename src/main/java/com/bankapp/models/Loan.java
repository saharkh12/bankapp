package com.bankapp.models;

import com.bankapp.enums.LoanType;
import com.bankapp.enums.RepetitionRule;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a loan within the bank application.
 */
public class Loan implements Comparable<Loan>, Serializable {
    private static final long serialVersionUID = 1L;
    private double interest;
    private double amount;
    private RepetitionRule repetRule;
    private LoanType type;
    private Date startDate;
    private double monthlyPayment;
    private Account accountUsed;

    /**
     * Constructs a new Loan with the specified details.
     *
     * @param interest the interest rate of the loan
     * @param amount the total amount of the loan
     * @param repetRule the repetition rule for payments
     * @param type the type of the loan
     * @param startDate the start date of the loan
     * @param monthlyPayment the monthly payment amount for the loan
     * @param accountUsed the account used for the loan
     */
    public Loan(double interest, double amount, RepetitionRule repetRule, LoanType type, Date startDate, double monthlyPayment, Account accountUsed) {
        this.interest = interest;
        this.amount = amount;
        this.repetRule = repetRule;
        this.type = type;
        this.startDate = startDate;
        this.monthlyPayment = monthlyPayment;
        this.accountUsed = accountUsed;
    }

    // Getters and Setters

    /**
     * Gets the interest rate of the loan.
     *
     * @return the interest rate of the loan
     */
    public double getInterest() {
        return interest;
    }

    /**
     * Sets the interest rate of the loan.
     *
     * @param interest the interest rate to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * Gets the total amount of the loan.
     *
     * @return the total amount of the loan
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the total amount of the loan.
     *
     * @param amount the total amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the repetition rule for payments.
     *
     * @return the repetition rule for payments
     */
    public RepetitionRule getRepetRule() {
        return repetRule;
    }

    /**
     * Sets the repetition rule for payments.
     *
     * @param repetRule the repetition rule to set
     */
    public void setRepetRule(RepetitionRule repetRule) {
        this.repetRule = repetRule;
    }

    /**
     * Gets the type of the loan.
     *
     * @return the type of the loan
     */
    public LoanType getType() {
        return type;
    }

    /**
     * Sets the type of the loan.
     *
     * @param type the type to set
     */
    public void setType(LoanType type) {
        this.type = type;
    }

    /**
     * Gets the start date of the loan.
     *
     * @return the start date of the loan
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the loan.
     *
     * @param startDate the start date to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the monthly payment amount for the loan.
     *
     * @return the monthly payment amount
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Sets the monthly payment amount for the loan.
     *
     * @param monthlyPayment the monthly payment amount to set
     */
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Gets the account used for the loan.
     *
     * @return the account used for the loan
     */
    public Account getAccountUsed() {
        return accountUsed;
    }

    /**
     * Sets the account used for the loan.
     *
     * @param accountUsed the account to set
     */
    public void setAccountUsed(Account accountUsed) {
        this.accountUsed = accountUsed;
    }

    // Methods

    /**
     * Calculates the remaining amount of the loan.
     *
     * @return the remaining amount of the loan
     */
    public double amountRemind() {
        return this.amount - (this.monthlyPayment * monthsPassed());
    }

    /**
     * Deduces the monthly payment amount from the loan.
     *
     * @return the monthly payment amount
     */
    public double deduce() {
        return this.monthlyPayment;
    }

    /**
     * Calculates the number of months passed since the start date of the loan.
     *
     * @return the number of months passed
     */
    private int monthsPassed() {
        Date currentDate = new Date();
        int monthsPassed = (currentDate.getYear() - this.startDate.getYear()) * 12 + (currentDate.getMonth() - this.startDate.getMonth());
        return monthsPassed;
    }

    /**
     * Compares this loan to another loan based on the amount.
     *
     * @param other the other loan to compare to
     * @return a negative integer, zero, or a positive integer as this loan's amount is less than, equal to, or greater than the other loan's amount
     */
    @Override
    public int compareTo(Loan other) {
        return Double.compare(this.amount, other.amount);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "interest=" + interest +
                ", amount=" + amount +
                ", repetRule=" + repetRule +
                ", type=" + type +
                ", startDate=" + startDate +
                ", monthlyPayment=" + monthlyPayment +
                ", accountUsed=" + accountUsed +
                '}';
    }
}
