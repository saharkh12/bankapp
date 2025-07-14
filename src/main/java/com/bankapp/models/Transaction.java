package com.bankapp.models;

import com.bankapp.enums.Status;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a transaction within the bank application.
 */
public class Transaction implements Comparable<Transaction>, Serializable {
    private static final long serialVersionUID = 1L;
    private int ID;
    private Date executionDate;
    private Status status;
    private double amount;
    private String note;
    private Account targetAccount;
    private Account usedAccount;

    /**
     * Constructs a new Transaction with the specified details.
     *
     * @param ID the unique identifier of the transaction
     * @param executionDate the date the transaction was executed
     * @param status the current status of the transaction
     * @param amount the amount involved in the transaction
     * @param note additional notes regarding the transaction
     * @param targetAccount the account receiving the transaction amount
     * @param usedAccount the account from which the transaction amount is deducted
     */
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

    /**
     * Gets the unique identifier of the transaction.
     *
     * @return the unique identifier of the transaction
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets the unique identifier of the transaction.
     *
     * @param ID the unique identifier to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Gets the date the transaction was executed.
     *
     * @return the execution date of the transaction
     */
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     * Sets the date the transaction was executed.
     *
     * @param executionDate the execution date to set
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     * Gets the current status of the transaction.
     *
     * @return the status of the transaction
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the current status of the transaction.
     *
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the amount involved in the transaction.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount involved in the transaction.
     *
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets additional notes regarding the transaction.
     *
     * @return the transaction note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets additional notes regarding the transaction.
     *
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the account receiving the transaction amount.
     *
     * @return the target account of the transaction
     */
    public Account getTargetAccount() {
        return targetAccount;
    }

    /**
     * Sets the account receiving the transaction amount.
     *
     * @param targetAccount the target account to set
     */
    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    /**
     * Gets the account from which the transaction amount is deducted.
     *
     * @return the used account of the transaction
     */
    public Account getUsedAccount() {
        return usedAccount;
    }

    /**
     * Sets the account from which the transaction amount is deducted.
     *
     * @param usedAccount the used account to set
     */
    public void setUsedAccount(Account usedAccount) {
        this.usedAccount = usedAccount;
    }

    // Methods

    /**
     * Checks if the transaction has been proceeded.
     *
     * @return true if the transaction has been proceeded, false otherwise
     */
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
