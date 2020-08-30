package com.example.calculator.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.lang.module.FindException;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private long phone;
    private int kitchen_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name="kitchen_id", insertable = false, updatable = false)
    private Kitchen kitchen;


    public Customer() {
    }

    public Customer(String name,long phone,Kitchen kitchen){
        this.name = name;
        this.phone = phone;
        this.kitchen = kitchen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public String toString() {
        return "id: " +id + "\n" +" имя: " +name+ "\n" + "телефон: "+ phone + kitchen.getFasady();
    }
}
