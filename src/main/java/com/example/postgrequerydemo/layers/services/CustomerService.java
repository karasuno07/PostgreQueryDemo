package com.example.postgrequerydemo.layers.services;

import com.example.postgrequerydemo.objects.entities.Customer;

import java.util.Collection;

public interface CustomerService {

    Collection<Customer> findAllCustomers();

    Customer findCustomerById(int id);
}
