package com.bankapp.models;

import com.bankapp.enums.Status;
import com.bankapp.enums.Status;
import java.io.Serializable;

import java.util.Date;

public class Transaction implements Comparable<Transaction>, Serializable {
    private int ID;
    private Date executionDate;
    private Status status;
    private double amount;
    private String note;
    private Account targetAccount;
    private Account usedAccount;

    public Transaction(int ID, Date executionDate, Status status, double amount, String note, Account targetAccount, Account usedAccount) {
        this.ID = ID;
        this.executionDate = executionDate;
        this.status = status;
        this.amount = amount;
        this.note = note;
        this.targetAccount = targetAccount;
        this.usedAccount = usedAccount;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public Account getUsedAccount() {
        return usedAccount;
    }

    public void setUsedAccount(Account usedAccount) {
        this.usedAccount = usedAccount;
    }

    // Methods
    public boolean isProceeded() {
        return this.status == Status.PROCEEDED;
    }

    @Override
    public int compareTo(Transaction other) {
        return Integer.compare(this.ID, other.ID);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID=" + ID +
                ", executionDate=" + executionDate +
                ", status=" + status +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                ", targetAccount=" + targetAccount +
                ", usedAccount=" + usedAccount +
                '}';
    }
}
