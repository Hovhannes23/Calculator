package com.example.calculator.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "kitchen")
public class Kitchen {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private double size;
    private Enum<Fasady> fasady;
    private Enum<Visota> visota;
    private Enum<Stoleshnica> stoleshnica;
    private Enum<Fartuk> fartuk;
    private Enum<Furnitura> furnitura;
    private int yashiki;
    private int sum;

    @OneToOne(mappedBy = "kitchen", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    public Kitchen(double size, Enum<Fasady> fasady,
                   Enum<Visota> visota, Enum<Stoleshnica> stoleshnica,
                   Enum<Fartuk> fartuk, Enum<Furnitura> furnitura,
                   int yashiki, int sum) {

        this.size = size;
        this.fasady = fasady;
        this.visota = visota;
        this.stoleshnica = stoleshnica;
        this.fartuk = fartuk;
        this.furnitura = furnitura;
        this.yashiki = yashiki;
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Enum<Fasady> getFasady() {
        return fasady;
    }

    public void setFasady(Enum<Fasady> fasady) {
        this.fasady = fasady;
    }

    public Enum<Visota> getVisota() {
        return visota;
    }

    public void setVisota(Enum<Visota> visota) {
        this.visota = visota;
    }

    public Enum<Stoleshnica> getStoleshnica() {
        return stoleshnica;
    }

    public void setStoleshnica(Enum<Stoleshnica> stoleshnica) {
        this.stoleshnica = stoleshnica;
    }

    public Enum<Fartuk> getFartuk() {
        return fartuk;
    }

    public void setFartuk(Enum<Fartuk> fartuk) {
        this.fartuk = fartuk;
    }

    public Enum<Furnitura> getFurnitura() {
        return furnitura;
    }

    public void setFurnitura(Enum<Furnitura> furnitura) {
        this.furnitura = furnitura;
    }

    public int getYashiki() {
        return yashiki;
    }

    public void setYashiki(int yashiki) {
        this.yashiki = yashiki;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kitchen(){

    }
}


