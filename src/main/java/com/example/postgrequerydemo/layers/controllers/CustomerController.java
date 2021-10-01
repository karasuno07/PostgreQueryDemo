package com.example.postgrequerydemo.layers.controllers;

import com.example.postgrequerydemo.layers.services.CustomerService;
import com.example.postgrequerydemo.objects.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer> customers =
                new ArrayList<>(customerService.findAllCustomers());

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable("id") int id
    ) {
        Customer customer = customerService.findCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
