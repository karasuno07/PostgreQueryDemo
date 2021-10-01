package com.example.postgrequerydemo.layers.repositories;

import com.example.postgrequerydemo.objects.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
