package com.kgisl.sb1.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kgisl.sb1.model.Customer;
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/")
    public List<Customer> welcome(){
List<Customer> customers = new ArrayList<Customer>();
Customer c1 = new Customer();
c1.setId(1);
c1.setFirstName("Maddy");
c1.setLastName("lastName");
c1.setEmail("email");
customers.add(c1);
        return customers;
    }
}

