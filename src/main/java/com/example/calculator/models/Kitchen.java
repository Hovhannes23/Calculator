package com.example.calculator.models;

import org.springframework.stereotype.Component;

@Component
public class Kitchen {

    private double size;
    private Enum<Fasady> fasady;
    private Enum<Visota> visota;
    private Enum<Stoleshnica> stoleshnica;
    private Enum<Fartuk> fartuk;
    private Enum<Furnitura> furnitura;
    private int yashiki;
    private int sum;


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
}


