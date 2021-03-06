package com.example.calculator;

import com.example.calculator.models.*;
import com.example.calculator.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CalculatorApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CalculatorApplication.class, args);

    }

}
