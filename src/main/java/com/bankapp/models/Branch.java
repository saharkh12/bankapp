package com.bankapp.models;

import com.bankapp.collections.EmployeeCollection;
import java.io.Serializable;

/**
 * Represents a branch within the bank application.
 */
public class Branch implements Comparable<Branch>, Serializable {
    private static final long serialVersionUID = 1L;
    private int branchId;
    private String location;
    private EmployeeCollection employees;
    private ATM atm;

    /**
     * Constructs a new Branch with the specified details.
     *
     * @param branchId the unique identifier of the branch
     * @param location the location of the branch
     * @param employees the collection of employees working at the branch
     * @param atm the ATM associated with the branch
     */
    public Branch(int branchId, String location, EmployeeCollection employees, ATM atm) {
        this.branchId = branchId;
        this.location = location;
        this.employees = employees;
        this.atm = atm;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the branch.
     *
     * @return the branch ID
     */
    public int getBranchId() {
        return branchId;
    }

    /**
     * Sets the unique identifier of the branch.
     *
     * @param branchId the branch ID to set
     */
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    /**
     * Gets the location of the branch.
     *
     * @return the location of the branch
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the branch.
     *
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the collection of employees working at the branch.
     *
     * @return the collection of employees
     */
    public EmployeeCollection getEmployees() {
        return employees;
    }

    /**
     * Sets the collection of employees working at the branch.
     *
     * @param employees the collection of employees to set
     */
    public void setEmployees(EmployeeCollection employees) {
        this.employees = employees;
    }

    /**
     * Gets the ATM associated with the branch.
     *
     * @return the ATM associated with the branch
     */
    public ATM getAtm() {
        return atm;
    }

    /**
     * Sets the ATM associated with the branch.
     *
     * @param atm the ATM to set
     */
    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    // Methods

    /**
     * Adds an employee to the branch.
     *
     * @param employee the employee to add
     */
    public void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    /**
     * Sets the ATM for the branch.
     *
     * @param atm the ATM to set
     */
    public void setATM(ATM atm) {
        this.atm = atm;
    }

    /**
     * Compares this branch to another branch based on the branch ID.
     *
     * @param other the other branch to compare to
     * @return a negative integer, zero, or a positive integer as this branch's ID is less than, equal to, or greater than the other branch's ID
     */
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
