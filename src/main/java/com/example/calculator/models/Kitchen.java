package com.example.calculator.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

@Component
@Entity
public class Kitchen{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double size;
    private Enum<Fasady> fasady;
    private Enum<Visota> visota;
    private Enum<Stoleshnica> stoleshnica;
    private Enum<Fartuk> fartuk;
    private Enum<Furnitura> furnitura;
    private int yashiki;
    private int sum;

    @OneToOne(mappedBy = "kitchen",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public Kitchen(){
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

    @Override
    public String toString() {
        return "Kitchen{" +
                "id=" + id +
                ", size=" + size +
                ", fasady=" + fasady +
                ", visota=" + visota +
                ", stoleshnica=" + stoleshnica +
                ", fartuk=" + fartuk +
                ", furnitura=" + furnitura +
                ", yashiki=" + yashiki +
                ", sum=" + sum +
                '}';
    }
}


