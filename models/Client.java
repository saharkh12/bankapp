package com.bankapp.models;

import com.bankapp.enums.IdentifyType;
import com.bankapp.collections.AccountCollection;
import java.io.Serializable;

import java.util.Date;

public class Client implements Comparable<Client>, Serializable {
    private int clientID;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String password;
    private AccountCollection accounts;
    private IdentifyType identifyType; 

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
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountCollection getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountCollection accounts) {
        this.accounts = accounts;
    }

    public IdentifyType getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(IdentifyType identifyType) {
        this.identifyType = identifyType;
    }

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
