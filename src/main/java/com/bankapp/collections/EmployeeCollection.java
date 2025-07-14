package com.bankapp.collections;

import com.bankapp.models.Employee;
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

public class EmployeeCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Employee> employees;
    private static final String path = "data/employees.ser";

    public EmployeeCollection() {
        employees = new LinkedList<>();
    }

    public ListIterator<Employee> getEmployees() {
        return employees.listIterator();
    }

    public boolean addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void editEmployee(Employee oldEmployee, Employee newEmployee) {
        int index = employees.indexOf(oldEmployee);
        if (index >= 0) {
            employees.set(index, newEmployee);
        }
    }

    public List<Employee> searchByName(String name) {
        List<Employee> results = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                results.add(employee);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortEmployees() {
        Collections.sort(employees);
    }

    public void sortEmployeesDescending() {
        Collections.sort(employees, Collections.reverseOrder());
    }

    public void sortEmployees(Comparator<Employee> comp) {
        Collections.sort(employees, comp);
    }

    public boolean findEmployee(Employee employee) {
        sortEmployees();
        int index = Collections.binarySearch(employees, employee);
        return index >= 0;
    }

    public void findEmployee(Employee employee, Comparator<Employee> comp) {
        sortEmployees(comp);
        int index = Collections.binarySearch(employees, employee, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override

    public String toString() {
        StringBuilder str = new StringBuilder();
    
        if (employees != null) {
            ListIterator<Employee> iter = employees.listIterator();
            while (iter.hasNext()) {
                Employee employee = iter.next();
                str.append(employee.toString());
                str.append("\n");
            }
        }
    
        return str.toString();
    }

    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                employees = (List<Employee>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
