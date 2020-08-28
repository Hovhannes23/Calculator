package com.example.calculator.controllers;

import com.example.calculator.models.*;
import com.example.calculator.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    Calculator calculator;

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/calculator")
    public String main()
    {
        return "calculator";
    }

    @PostMapping("/price")
    public String price(@RequestParam double size,
                        @RequestParam String fasady,
                        @RequestParam String visota,
                        @RequestParam String stoleshnica,
                        @RequestParam String fartuk,
                        @RequestParam String furnitura,
                        @RequestParam int yashiki, Model model){

       int kitchenPrice = (int) calculator.calculate(size, Fasady.getFasadyByName(fasady), Visota.getVisotaByHeight(visota),
                            Stoleshnica.getStoleshnicaByName(stoleshnica), Fartuk.getFartukByName(fartuk),
                            Furnitura.getFurnituraByName(furnitura), yashiki);


        model.addAttribute("kitchenPrice",kitchenPrice);

        return "price";
    }

    @PostMapping("/meeting")
    public String meeting(@RequestParam String name,
                          @RequestParam long phone,
                          Model model)
    {
        Customer customer = new Customer(name,phone);
        customerRepo.save(customer);
        return "meeting";
    };

    @GetMapping("/customers")
    public String getCustomers(Model model){
       Iterable<Customer> customers = customerRepo.findAll();
       model.addAttribute("customers",customers);
        return "customers";
    }

    
   @GetMapping("/edit/{id}")
    public String editById(@PathVariable(value="id") long id, Model model){
    Customer customer = customerRepo.findById(id).orElseThrow();
       Iterable<Customer> customers = customerRepo.findAll();
       model.addAttribute("customers",customers);
    model.addAttribute("customer", customer);
    return "edit";
   }

   @PostMapping("/edit/{id}")
    public String editById(@PathVariable(value ="id") long id, String name, Long phone){
        Customer customer = customerRepo.findById(id).orElseThrow();
        customer.setName(name);
        customer.setPhone(phone);
        customerRepo.save(customer);
        return "redirect:/customers";

   };


}
