package com.example.calculator.repo;

import com.example.calculator.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
