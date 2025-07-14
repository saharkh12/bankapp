package com.bankapp.collections;

import com.bankapp.models.Loan;
import com.bankapp.enums.LoanType;
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

public class LoanCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Loan> loans;
    private static final String path = "data/loans.ser";

    public LoanCollection() {
        loans = new LinkedList<>();
    }

    public ListIterator<Loan> getLoans() {
        return loans.listIterator();
    }

    public boolean addLoan(Loan loan) {
        if (!loans.contains(loan)) {
            loans.add(loan);
            return true;
        }
        return false;
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public void editLoan(Loan oldLoan, Loan newLoan) {
        int index = loans.indexOf(oldLoan);
        if (index >= 0) {
            loans.set(index, newLoan);
        }
    }

    public List<Loan> searchByType(LoanType type) {
        List<Loan> results = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getType() == type) {
                results.add(loan);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortLoans() {
        Collections.sort(loans);
    }

    public void sortLoansDescending() {
        Collections.sort(loans, Collections.reverseOrder());
    }

    public void sortLoans(Comparator<Loan> comp) {
        Collections.sort(loans, comp);
    }

    public boolean findLoan(Loan loan) {
        sortLoans();
        int index = Collections.binarySearch(loans, loan);
        return index >= 0;
    }

    public void findLoan(Loan loan, Comparator<Loan> comp) {
        sortLoans(comp);
        int index = Collections.binarySearch(loans, loan, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Loan> iter = loans.listIterator();
        while (iter.hasNext()) {
            Loan loan = iter.next();
            str.append(loan.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(loans);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                loans = (List<Loan>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
