package com.bankapp.collections;

import com.bankapp.models.Payment;
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


public class PaymentCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Payment> payments;
    private static final String path = "data/payments.ser";

    public PaymentCollection() {
        payments = new LinkedList<>();
    }

    public ListIterator<Payment> getPayments() {
        return payments.listIterator();
    }

    public boolean addPayment(Payment payment) {
        if (!payments.contains(payment)) {
            payments.add(payment);
            return true;
        }
        return false;
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    public void editPayment(Payment oldPayment, Payment newPayment) {
        int index = payments.indexOf(oldPayment);
        if (index >= 0) {
            payments.set(index, newPayment);
        }
    }

    public List<Payment> searchByAmount(double amount) {
        List<Payment> results = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getAmount() == amount) {
                results.add(payment);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortPayments() {
        Collections.sort(payments);
    }

    public void sortPaymentsDescending() {
        Collections.sort(payments, Collections.reverseOrder());
    }

    public void sortPayments(Comparator<Payment> comp) {
        Collections.sort(payments, comp);
    }

    public boolean findPayment(Payment payment) {
        Collections.sort(payments);
        int index = Collections.binarySearch(payments, payment);
        return index >= 0;
    }

    public void findPayment(Payment payment, Comparator<Payment> comp) {
        Collections.sort(payments, comp);
        int index = Collections.binarySearch(payments, payment, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Payment> iter = payments.listIterator();
        while (iter.hasNext()) {
            Payment payment = iter.next();
            str.append(payment.toString());
            str.append("\n");
        }
        return str.toString();
    }


    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(payments);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                payments = (List<Payment>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}