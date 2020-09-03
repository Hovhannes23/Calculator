package com.example.calculator.repo;

import com.example.calculator.models.Kitchen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface KitchenRepo extends CrudRepository<Kitchen,Long> {

}
