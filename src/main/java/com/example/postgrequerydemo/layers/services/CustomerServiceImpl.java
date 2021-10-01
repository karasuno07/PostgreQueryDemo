package com.example.postgrequerydemo.layers.services;

import com.example.postgrequerydemo.layers.repositories.CustomerRepo;
import com.example.postgrequerydemo.objects.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Collection<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Not found customer with id " + id
                        )
                );
    }
}
