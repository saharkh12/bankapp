package com.bankapp;

import com.bankapp.collections.AccountCollection;
import com.bankapp.collections.BranchCollection;
import com.bankapp.collections.ClientCollection;
import com.bankapp.collections.EmployeeCollection;
import com.bankapp.collections.LoanCollection;
import com.bankapp.collections.PaymentCollection;
import com.bankapp.collections.TransactionCollection;
import com.bankapp.enums.IdentifyType;
import com.bankapp.models.ATM;
import com.bankapp.models.Account;
import com.bankapp.models.Branch;
import com.bankapp.models.Client;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BankApp {
    private BranchCollection branches;
    private ClientCollection clients;
    private AccountCollection accounts;


    public BankApp() {
        branches = new BranchCollection();
        clients = new ClientCollection();
        accounts = new AccountCollection();

        loadData();
    }

    public static void main(String[] args) {
        BankApp app = new BankApp();
        app.runMenu();
        app.saveData();
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  
            switch (choice) {
                case 1:
                    iAmAClient();
                    break;
                case 2:
                    toBeAClient();
                    break;
                case 3:
                    seeBranches();
                    break;
                case 4:
                    addBranch();
                    break;
                case 5:
                    deleteBranch();
                    break;
                case 6:
                    searchForBranchByID();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. I am a client");
        System.out.println("2. To be a client");
        System.out.println("3. See branches");
        System.out.println("4. Add branch");
        System.out.println("5. Delete branch");
        System.out.println("6. Search For Branch by ID");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public void searchForBranchByID(){
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter branch ID: ");
        int branchId = scanner.nextInt();
        scanner.nextLine();
        
        Branch branch = branches.findBranchByID(branchId);
        
        if (branch == null)
            System.out.println("Branch not found.");
        else
            System.out.println(branch);
        
    }

    public void iAmAClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Client client = clients.findClientByIdAndPassword(clientId, password);

        if (client != null) {
            System.out.println("Client exists.");
            
        } else {
            System.out.println("Client not found. Please register as a client!");
            
        }
    }

    public void toBeAClient() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter client ID: ");
        int clientID = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
    
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
    
        System.out.print("Enter birth date (yyyy-MM-dd): ");
        String birthDateString = scanner.nextLine();
        
        Date birthDate = null;
        
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
    
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        AccountCollection accounts = new AccountCollection();
    
    
        IdentifyType identifyType = IdentifyType.PASSPORT; 
    
        Client newClient = new Client(clientID, firstName, lastName, birthDate, password, accounts, identifyType);
    
        clients.addClient(newClient); 
    
        System.out.println("\nEnter account details:");
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
    
        scanner.nextLine(); 
    
        System.out.print("Enter RIB (Account Number): ");
        int RIB = scanner.nextInt();
    
        scanner.nextLine(); 
    
        System.out.print("Enter opening date (yyyy-MM-dd): ");
        String openingDateString = scanner.nextLine();
        Date openingDate = null;
        try {
            openingDate = new SimpleDateFormat("yyyy-MM-dd").parse(openingDateString);
        } catch (ParseException e) {
            e.printStackTrace(); 
            return;
        }
    
        Date closingDate = null; 
    
        boolean isDisabled = false; 
      
        Account newAccount = new Account(newClient, initialBalance, RIB, openingDate, closingDate, isDisabled, new PaymentCollection(),new TransactionCollection(), new LoanCollection());
    
        newClient.getAccounts().addAccount(newAccount);
        accounts.addAccount(newAccount);
    
        System.out.println("\nClient added: " + newClient);
        System.out.println("Account added: " + newAccount);
    }

    public void seeBranches() {
        System.out.println("Branches:");
        System.out.println(branches.toString());
    }

    public void addBranch() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter branch ID: ");
        int branchId = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Enter branch location: ");
        String location = scanner.nextLine();
    
        System.out.print("Enter ATM ID: ");
        int atmId = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Enter ATM location: ");
        String atmLocation = scanner.nextLine();
    
        System.out.print("Enter cash available in ATM: ");
        double cashAvailable = scanner.nextDouble();
    
        ATM atm = new ATM(atmId, atmLocation, cashAvailable);
    
        Branch newBranch = new Branch(branchId, location, new EmployeeCollection(), atm);
    
        branches.addBranch(newBranch);
    
        System.out.println("Branch added: " + newBranch);
}

    public void deleteBranch() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the branch ID to delete: ");
        int branchIdToDelete = scanner.nextInt();
    
        boolean success = branches.removeByID(branchIdToDelete); 
    
        if (success) {
            System.out.println("Branch deleted successfully.");
        } else {
            System.out.println("Branch with ID " + branchIdToDelete + " not found.");
        }
}

    private void saveData() {
        try {
            branches.save();
            clients.save();
            accounts.save();

        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            branches.load();
            clients.load();
            accounts.load();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}
