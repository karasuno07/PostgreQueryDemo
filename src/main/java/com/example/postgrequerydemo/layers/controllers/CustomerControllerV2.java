package com.example.postgrequerydemo.layers.controllers;

import com.example.postgrequerydemo.layers.services.CustomerService;
import com.example.postgrequerydemo.objects.dto.CustomerDTO;
import com.example.postgrequerydemo.objects.entities.Customer;
import com.example.postgrequerydemo.objects.mappers.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerControllerV2 {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public CustomerControllerV2(
            CustomerService customerService,
            CustomerMapper customerMapper
    ) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    private CustomerDTO convertToCustomerDTO(Customer customer) {
        return customerMapper.customerToCustomerDTO(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        List<Customer> customers =
                new ArrayList<>(customerService.findAllCustomers());

        List<CustomerDTO> transferObject =
                customers.stream()
                        .map(this::convertToCustomerDTO)
                        .collect(Collectors.toList());

        return new ResponseEntity<>(transferObject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(
            @PathVariable("id") int id
    ) {
        Customer customer = customerService.findCustomerById(id);

        CustomerDTO transferObject = convertToCustomerDTO(customer);

        return new ResponseEntity<>(transferObject, HttpStatus.OK);
    }
}
