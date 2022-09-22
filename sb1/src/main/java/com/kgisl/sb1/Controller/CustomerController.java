package com.kgisl.sb1.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kgisl.sb1.model.Customer;
import com.kgisl.sb1.service.CustomerService;
@RestController
@RequestMapping("/Customers")
public class CustomerController {
    @Autowired
    private CustomerService CustomerServices;
    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(CustomerServices.getCustomers(), HttpStatus.OK);
    }
    // Read
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getTeamById(@PathVariable("id") int id) {
        Customer Customer = CustomerServices.findCustomerById(id);
        if (Customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Customer, HttpStatus.OK);
    }
    // Create
    @PostMapping(value = "/")
    public ResponseEntity<Customer> createTeam(@RequestBody Customer customer) {
        Customer actualUser = CustomerServices.createCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
        return new ResponseEntity<>(actualUser, headers, HttpStatus.CREATED);
    }
    // update
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateUser(@PathVariable("id") Integer id, @RequestBody Customer currentUser) {
        Customer customer = CustomerServices.updateCustomer(id, currentUser);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
   // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
        Customer customer = CustomerServices.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CustomerServices.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}