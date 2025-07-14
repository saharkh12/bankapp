package com.bankapp.collections;

import com.bankapp.models.Branch;
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

public class BranchCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Branch> branches;
    private static final String path = "data/branches.ser";

    public BranchCollection() {
        branches = new LinkedList<>();
    }

    public ListIterator<Branch> getBranches() {
        return branches.listIterator();
    }

    public boolean addBranch(Branch branch) {
        if (!branches.contains(branch)) {
            branches.add(branch);
            return true;
        }
        return false;
    }

    public void removeBranch(Branch branch) {
        branches.remove(branch);
    }
    
    public boolean removeByID(int branchId) {
    for (Branch branch : branches) {
        if (branch.getBranchId() == branchId) {
            branches.remove(branch); 
            return true; 
        }
    }
        return false;
    }

    public void editBranch(Branch oldBranch, Branch newBranch) {
        int index = branches.indexOf(oldBranch);
        if (index >= 0) {
            branches.set(index, newBranch);
        }
    }

    public List<Branch> searchByLocation(String location) {
        List<Branch> results = new ArrayList<>();
        for (Branch branch : branches) {
            if (branch.getLocation().equalsIgnoreCase(location)) {
                results.add(branch);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortBranches() {
        Collections.sort(branches);
    }

    public void sortBranchesDescending() {
        Collections.sort(branches, Collections.reverseOrder());
    }

    public void sortBranches(Comparator<Branch> comp) {
        Collections.sort(branches, comp);
    }

    public boolean findBranch(Branch branch) {
        sortBranches();
        int index = Collections.binarySearch(branches, branch);
        return index >= 0;
    }

    public void findBranch(Branch branch, Comparator<Branch> comp) {
        sortBranches(comp);
        int index = Collections.binarySearch(branches, branch, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Branch> iter = branches.listIterator();
        while (iter.hasNext()) {
            Branch branch = iter.next();
            str.append(branch.toString());
            str.append("\n");
        }
        return str.toString();
    }
    
    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(branches);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                branches = (List<Branch>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}