package com.kgisl.sb1.service;
import java.util.List;
import com.kgisl.sb1.model.Customer;
public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer createCustomer(Customer team);
    public Customer updateCustomer(int id,Customer team);
    public void deleteCustomerById(int id);
    public Customer findCustomerById(int id);
}