package com.example.calculator.controllers;

import com.example.calculator.models.*;
import com.example.calculator.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                        @RequestParam int yashiki, ModelMap model){



       Map<String,Integer> prices =  calculator.calculate(size, Fasady.getFasadyByName(fasady), Visota.getVisotaByHeight(visota),
                            Stoleshnica.getStoleshnicaByName(stoleshnica), Fartuk.getFartukByName(fartuk),
                            Furnitura.getFurnituraByName(furnitura), yashiki);

        Kitchen kitchen = new Kitchen(size,Fasady.getFasadyByName(fasady),Visota.getVisotaByHeight(visota),
                Stoleshnica.getStoleshnicaByName(stoleshnica),Fartuk.getFartukByName(fartuk),Furnitura.getFurnituraByName(furnitura),
                yashiki,prices.get("sum"));

        model.addAttribute("kitchenPrice",prices.get("sum"));
        model.addAttribute("discount",prices.get("discount"));
        model.addAttribute("sumWithDiscount",prices.get("sumWithDiscount"));
        model.addAttribute("stoleshnicaPrice",prices.get("stoleshnicaPrice"));
        model.addAttribute("fartukPrice",prices.get("fartukPrice"));
        model.addAttribute("furnituraPrice",prices.get("furnituraPrice"));
        model.addAttribute("yashikiPrice", prices.get("yashikiPrice"));
        model.addAttribute("sborka",prices.get("sborka"));

        model.put("kitchen",kitchen);

        return "price";
    }

    @PostMapping("/meeting")
    public String meeting(@RequestParam String name,
                          @RequestParam long phone,
//                          @RequestParam double size,
//                          @RequestParam int kitchenPrice,
//                          @RequestParam int discount,
//                          @RequestParam int sumWithDiscount,
//                          @RequestParam int sborka,
//                          @RequestParam Enum<Stoleshnica> stoleshnica,
//                          @RequestParam Enum<Furnitura> furnitura,
//                          @RequestParam int yashiki,
                          @ModelAttribute("kitchen") Kitchen kitchen,
                          ModelMap model)
    {

        Customer customer = new Customer(name,phone,kitchen);
        model.addAttribute("kitchen", kitchen);
        model.put("kitchen",kitchen);
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
