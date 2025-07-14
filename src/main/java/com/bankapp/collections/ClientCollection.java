package com.bankapp.collections;

import com.bankapp.models.Client;
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

public class ClientCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Client> clients;
    private static final String path = "data/clients.ser";

    public ClientCollection() {
        clients = new LinkedList<>();
    }

    public ListIterator<Client> getClients() {
        return clients.listIterator();
    }

    public boolean addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
            return true;
        }
        return false;
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void editClient(Client oldClient, Client newClient) {
        int index = clients.indexOf(oldClient);
        if (index >= 0) {
            clients.set(index, newClient);
        }
    }

    public List<Client> searchByFirstName(String firstName) {
        List<Client> results = new ArrayList<>();
        for (Client client : clients) {
            if (client.getFirstName().equalsIgnoreCase(firstName)) {
                results.add(client);
            }
        }
        return results;
    }

    // Natural ordering
    public void sortClients() {
        Collections.sort(clients);
    }

    public void sortClientsDescending() {
        Collections.sort(clients, Collections.reverseOrder());
    }

    public void sortClients(Comparator<Client> comp) {
        Collections.sort(clients, comp);
    }

    public boolean findClient(Client client) {
        sortClients();
        int index = Collections.binarySearch(clients, client);
        return index >= 0;
    }
    
    public Client findClientByIdAndPassword(int clientId, String password) {
        for (Client client : clients) {
            if (client.getClientID() == clientId && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null; 
    }

    public void findClient(Client client, Comparator<Client> comp) {
        sortClients(comp);
        int index = Collections.binarySearch(clients, client, comp);
        if (index >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Client> iter = clients.listIterator();
        while (iter.hasNext()) {
            Client client = iter.next();
            str.append(client.toString());
            str.append("\n");
        }
        return str.toString();
    }
    
    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(clients);
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                clients = (List<Client>) obj;
            } else {
                System.err.println("Error: Unexpected data format in file " + path);
            }
        }
    }
}
