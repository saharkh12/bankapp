package com.bankapp.models;

import com.bankapp.enums.LoanType;
import com.bankapp.enums.RepetitionRule;
import java.io.Serializable;

import java.util.Date;

public class Loan implements Comparable<Loan>, Serializable {
    private double interest;
    private double amount;
    private RepetitionRule repetRule;
    private LoanType type;
    private Date startDate;
    private double monthlyPayment;
    private Account accountUsed;

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
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RepetitionRule getRepetRule() {
        return repetRule;
    }

    public void setRepetRule(RepetitionRule repetRule) {
        this.repetRule = repetRule;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Account getAccountUsed() {
        return accountUsed;
    }

    public void setAccountUsed(Account accountUsed) {
        this.accountUsed = accountUsed;
    }

    // Methods
    public double amountRemind() {
        return this.amount - (this.monthlyPayment * monthsPassed());
    }

    public double deduce() {
        return this.monthlyPayment;
    }

    private int monthsPassed() {
        Date currentDate = new Date();
        int monthsPassed = (currentDate.getYear() - this.startDate.getYear()) * 12 + (currentDate.getMonth() - this.startDate.getMonth());
        return monthsPassed;
    }
    
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
