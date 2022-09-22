package com.kgisl.sb1.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgisl.sb1.model.Customer;
import com.kgisl.sb1.repository.CustomerRepository;
    @Service
    public class CustomerServiceImpl implements CustomerService{
         @Autowired
         private CustomerRepository customerRepository;
        @Override
        public List<Customer> getCustomers() {
            return customerRepository.findAll();
        }
        @Override
        public Customer findCustomerById(int id) {
            customerRepository.findById(id);
            return  customerRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not Found"));
        }
        @Override
        public  Customer createCustomer(Customer c1) {
            Customer c=new Customer();
            c.setId(1);
            c.setFirstName("ma");
            c.setLastName("m");
            c.setEmail("ma@gmail.com");
            c.getId();
            c.getFirstName();
            c.getLastName();
            c.getEmail();
            c1=c;
           return customerRepository.save(c1);
        }
        @Override
        public Customer updateCustomer(int id,Customer currentUser) {
            Optional<Customer> cus = customerRepository.findById(id);
            Customer customer = cus.get();
            Customer c=new Customer();
            c.setId(0);
            c.setFirstName("maddy");
            c.setLastName("m");
            c.setEmail("maddy.m@gmail.com");
            c.getId();
            c.getFirstName();
            c.getLastName();
            c.getEmail();
            currentUser=c;
            System.out.println(customer);
            customer.setId(currentUser.getId());
            customer.setEmail(currentUser.getEmail());
            customer.setFirstName(currentUser.getFirstName());
            customer.setLastName(currentUser.getLastName());
            customerRepository.save(customer);
            return customerRepository.save(customer);
        }
        @Override
        public void deleteCustomerById(int id) {
           customerRepository.deleteById(id);
        }
    }