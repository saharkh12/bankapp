package com.bankapp.models;

import com.bankapp.enums.RepetitionRule;
import java.io.Serializable;

/**
 * Represents an employee within the bank application.
 */
public class Employee implements Comparable<Employee>, Serializable {
    private static final long serialVersionUID = 1L;
    private int employeeID;
    private String name;
    private double salary;
    private RepetitionRule salaryRepetition;
    private Client client;

    /**
     * Constructs a new Employee with the specified details.
     *
     * @param employeeID the unique identifier of the employee
     * @param name the name of the employee
     * @param salary the salary of the employee
     * @param salaryRepetition the repetition rule for the salary
     * @param client the client associated with the employee
     */
    public Employee(int employeeID, String name, double salary, RepetitionRule salaryRepetition, Client client) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.salaryRepetition = salaryRepetition;
        this.client = client;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the employee.
     *
     * @return the employee ID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param employeeID the employee ID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Gets the repetition rule for the salary.
     *
     * @return the repetition rule for the salary
     */
    public RepetitionRule getSalaryRepetition() {
        return salaryRepetition;
    }

    /**
     * Sets the repetition rule for the salary.
     *
     * @param salaryRepetition the repetition rule to set
     */
    public void setSalaryRepetition(RepetitionRule salaryRepetition) {
        this.salaryRepetition = salaryRepetition;
    }

    /**
     * Gets the client associated with the employee.
     *
     * @return the client associated with the employee
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client associated with the employee.
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Compares this employee to another employee based on the employee ID.
     *
     * @param other the other employee to compare to
     * @return a negative integer, zero, or a positive integer as this employee's ID is less than, equal to, or greater than the other employee's ID
     */
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeID, other.employeeID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", salaryRepetition=" + salaryRepetition +
                ", client=" + client +
                '}';
    }
}
