package com.bankapp.models;

import com.bankapp.enums.RepetitionRule;
import java.io.Serializable;
import java.util.Date;

public class Employee implements Comparable<Employee>, Serializable{
    private int employeeID;
    private String name;
    private double salary;
    private RepetitionRule salaryRepetition;
    private Client client;

    public Employee(int employeeID, String name, double salary, RepetitionRule salaryRepetition, Client client) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.salaryRepetition = salaryRepetition;
        this.client = client;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public RepetitionRule getSalaryRepetition() {
        return salaryRepetition;
    }

    public void setSalaryRepetition(RepetitionRule salaryRepetition) {
        this.salaryRepetition = salaryRepetition;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


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
