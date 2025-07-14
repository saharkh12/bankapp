package com.bankapp.collections;

import com.bankapp.models.SavingAccount;
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


public class SavingAccountCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<SavingAccount> savingAccounts;
    private static final String path = "data/savingAccounts.ser";

    public SavingAccountCollection() {
        savingAccounts = new LinkedList<>();
    }

    public ListIterator<SavingAccount> getSavingAccounts() {
        return savingAccounts.listIterator();
    }

    public boolean addSavingAccount(SavingAccount savingAccount) {
        if (!savingAccounts.contains(savingAccount)) {
            savingAccounts.add(savingAccount);
            return true;
        }
        return false;
    }

    public void removeSavingAccount(SavingAccount savingAccount) {
        savingAccounts.remove(savingAccount);
    }

    public void editSavingAccount(SavingAccount oldSavingAccount, SavingAccount newSavingAccount) {
        int index = savingAccounts.indexOf(oldSavingAccount);
        if (index >= 0) {
            savingAccounts.set(index, newSavingAccount);
        }
    }

    public List<SavingAccount> searchByInterestRate(double interestRate) {
        List<SavingAccount> results = new ArrayList<>();
        for (SavingAccount savingAccount : savingAccounts) {
            if (savingAccount.getInterestRate() == interestRate) {
                results.add(savingAccount);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortSavingAccounts() {
        Collections.sort(savingAccounts);
    }

    public void sortSavingAccountsDescending() {
        Collections.sort(savingAccounts, Collections.reverseOrder());
    }

    public void sortSavingAccounts(Comparator<SavingAccount> comp) {
        Collections.sort(savingAccounts, comp);
    }

    public boolean findSavingAccount(SavingAccount savingAccount) {
        sortSavingAccounts();
        int index = Collections.binarySearch(savingAccounts, savingAccount);
        return index >= 0;
    }

    public void findSavingAccount(SavingAccount savingAccount, Comparator<SavingAccount> comp) {
        sortSavingAccounts(comp);
        int index = Collections.binarySearch(savingAccounts, savingAccount, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<SavingAccount> iter = savingAccounts.listIterator();
        while (iter.hasNext()) {
            SavingAccount savingAccount = iter.next();
            str.append(savingAccount.toString());
            str.append("\n");
        }
        return str.toString();
    }
    
    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(savingAccounts);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                savingAccounts = (List<SavingAccount>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
