package com.bankapp.collections;

import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.models.Account;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class AccountCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Account> accounts;
    private static final String path = "data/accounts.ser";

    public AccountCollection() {
        accounts = new LinkedList<>();
    }

    public ListIterator<Account> getAccounts() {
        return accounts.listIterator();
    }

    public boolean addAccount(Account account) {
        if (!accounts.contains(account)) {
            accounts.add(account);
            return true;
        }
        return false;
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void editAccount(Account oldAccount, Account newAccount) {
        int index = accounts.indexOf(oldAccount);
        if (index >= 0) {
            accounts.set(index, newAccount);
        }
    }

    public List<Account> searchByClientID(int clientID) {
        List<Account> results = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getClient().getClientID() == clientID) {
                results.add(account);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortAccounts() {
        Collections.sort(accounts);
    }

    public void sortAccountsDescending() {
        Collections.sort(accounts, Collections.reverseOrder());
    }

    public void sortAccounts(Comparator<Account> comp) {
        Collections.sort(accounts, comp);
    }

    public boolean findAccount(Account account) throws AccountNotFoundException {
        sortAccounts();
        int index = Collections.binarySearch(accounts, account);
        if (index >= 0) {
            return true;
        } else {
            throw new AccountNotFoundException("Account not found.");
        }
    }

    public void findAccount(Account account, Comparator<Account> comp) {
        Collections.sort(accounts, comp);
        int index = Collections.binarySearch(accounts, account, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        if(accounts != null){
            ListIterator<Account> iter = accounts.listIterator();
            while (iter.hasNext()) {
                Account account = iter.next();
                str.append(account.toString());
                str.append("\n");
            }
        }
        
        return str.toString();
    }

    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(accounts);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                accounts = (List<Account>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
