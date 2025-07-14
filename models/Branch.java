package com.bankapp.models;

import com.bankapp.collections.EmployeeCollection;
import java.io.Serializable;

public class Branch implements Comparable<Branch>, Serializable {
    private int branchId;
    private String location;
    private EmployeeCollection employees;
    private ATM atm;

    public Branch(int branchId, String location, EmployeeCollection employees, ATM atm) {
        this.branchId = branchId;
        this.location = location;
        this.employees = employees;
        this.atm = atm;
    }

    // Getters and Setters
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EmployeeCollection getEmployees() {
        return employees;
    }

    public void setEmployees(EmployeeCollection employees) {
        this.employees = employees;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    // Methods
    public void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    public void setATM(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int compareTo(Branch other) {
        return Integer.compare(this.branchId, other.branchId);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                ", atm=" + atm +
                '}';
    }
}
