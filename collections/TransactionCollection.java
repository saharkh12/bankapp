package com.bankapp.collections;

import com.bankapp.models.SavingAccount;
import com.bankapp.models.Transaction;
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

public class TransactionCollection implements Serializable {
    private static List<Transaction> transactions;
    private static final long serialVersionUID = 1L;
    private static final String path = "data/transactions.ser";

    public TransactionCollection() {
        transactions = new LinkedList<>();
    }

    public ListIterator<Transaction> getTransactions() {
        return transactions.listIterator();
    }

    public boolean addTransaction(Transaction transaction) {
        if (!transactions.contains(transaction)) {
            transactions.add(transaction);
            return true;
        }
        return false;
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void editTransaction(Transaction oldTransaction, Transaction newTransaction) {
        int index = transactions.indexOf(oldTransaction);
        if (index >= 0) {
            transactions.set(index, newTransaction);
        }
    }

    public List<Transaction> searchByID(int ID) {
        List<Transaction> results = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getID() == ID) {
                results.add(transaction);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortTransactions() {
        Collections.sort(transactions);
    }

    public void sortTransactionsDescending() {
        Collections.sort(transactions, Collections.reverseOrder());
    }

    public void sortTransactions(Comparator<Transaction> comp) {
        Collections.sort(transactions, comp);
    }

    public boolean findTransaction(Transaction transaction) {
        sortTransactions();
        int index = Collections.binarySearch(transactions, transaction);
        return index >= 0;
    }

    public void findTransaction(Transaction transaction, Comparator<Transaction> comp) {
        sortTransactions(comp);
        int index = Collections.binarySearch(transactions, transaction, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Transaction> iter = transactions.listIterator();
        while (iter.hasNext()) {
            Transaction transaction = iter.next();
            str.append(transaction.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(transactions);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                transactions = (List<Transaction>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
