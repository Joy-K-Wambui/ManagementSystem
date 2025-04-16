/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerserviceticketingsystemswing.DAO;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Map;

public class CustomerManager {
    public static CustomerManager instance;
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customers;
    }
    private CustomerManager() {
        createSampleCustomers();
    }
    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    public Customer getCustomerById(String id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateCustomer(String id, String name, String email, String phone) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);
        }
    }
    

    private void createSampleCustomers() {
        addCustomer(new Customer(generateCustomerId(), "Alice Johnson", "alice@example.com", "1234567890"));
        addCustomer(new Customer(generateCustomerId(), "Bob Smith", "bob@example.com", "0987654321"));
        addCustomer(new Customer(generateCustomerId(), "Charlie Brown", "charlie@example.com", "1122334455"));
        addCustomer(new Customer(generateCustomerId(), "Daisy Miller", "daisy@example.com", "2233445566"));
        addCustomer(new Customer(generateCustomerId(), "Ella Fitzgerald", "ella@example.com", "3344556677"));
    }    
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Edit an existing customer
    public boolean editCustomer(String id, String newName, String newEmail, String newPhone) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(newName);
                customer.setEmail(newEmail);
                customer.setPhone(newPhone);
                return true;
            }
        }
        return false;
    }

    // Delete a customer by ID
    public boolean deleteCustomer(String id) {
        return customers.removeIf(customer -> customer.getId().equals(id));
    }
    
    public String generateCustomerId() {
        return UUID.randomUUID().toString();
    }
}
