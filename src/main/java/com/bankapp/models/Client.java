package com.bankapp.models;

import com.bankapp.enums.IdentifyType;
import com.bankapp.collections.AccountCollection;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents a client within the bank application.
 */
public class Client implements Comparable<Client>, Serializable {
    private static final long serialVersionUID = 1L;
    private int clientID;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String password;
    private AccountCollection accounts;
    private IdentifyType identifyType;

    /**
     * Constructs a new Client with the specified details.
     *
     * @param clientID the unique identifier of the client
     * @param firstName the first name of the client
     * @param lastName the last name of the client
     * @param birthDate the birth date of the client
     * @param password the password of the client
     * @param accounts the collection of accounts associated with the client
     * @param identifyType the identification type of the client
     */
    public Client(int clientID, String firstName, String lastName, Date birthDate, String password, AccountCollection accounts, IdentifyType identifyType) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.password = password;
        this.accounts = accounts;
        this.identifyType = identifyType;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the client.
     *
     * @return the client ID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Sets the unique identifier of the client.
     *
     * @param clientID the client ID to set
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Gets the first name of the client.
     *
     * @return the first name of the client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the client.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the client.
     *
     * @return the last name of the client
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the client.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the birth date of the client.
     *
     * @return the birth date of the client
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the client.
     *
     * @param birthDate the birth date to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the password of the client.
     *
     * @return the password of the client
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the client.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the collection of accounts associated with the client.
     *
     * @return the collection of accounts
     */
    public AccountCollection getAccounts() {
        return accounts;
    }

    /**
     * Sets the collection of accounts associated with the client.
     *
     * @param accounts the collection of accounts to set
     */
    public void setAccounts(AccountCollection accounts) {
        this.accounts = accounts;
    }

    /**
     * Gets the identification type of the client.
     *
     * @return the identification type
     */
    public IdentifyType getIdentifyType() {
        return identifyType;
    }

    /**
     * Sets the identification type of the client.
     *
     * @param identifyType the identification type to set
     */
    public void setIdentifyType(IdentifyType identifyType) {
        this.identifyType = identifyType;
    }

    /**
     * Compares this client to another client based on the client ID.
     *
     * @param other the other client to compare to
     * @return a negative integer, zero, or a positive integer as this client's ID is less than, equal to, or greater than the other client's ID
     */
    @Override
    public int compareTo(Client other) {
        return Integer.compare(this.clientID, other.clientID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", accounts=" + accounts +
                ", identifyType=" + identifyType +
                '}';
    }
}
