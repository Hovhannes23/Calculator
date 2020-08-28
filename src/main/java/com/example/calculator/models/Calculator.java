package com.example.calculator.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class Calculator implements Calculate {

    @Autowired
    Kitchen kitchen;


    @Override
    public double calculate(double size, Fasady fasady, Visota visota,
                            Stoleshnica stoleshnica, Fartuk fartuk,
                            Furnitura furnitura, int yashiki) {
        double sum = 0;
        double sumWithDiscount = 0;
        double fasadyPrice = 0;
        double visotaKef = 1;
        double stoleshnicaPrice = 0;
        double fartukPrice = 0;
        double furnituraPrice = 0;
        double yashikiPrice = 0;
        double discount = 0;

        switch (fasady) {
            case PLYONKA:
                fasadyPrice = 28000;
                break;
            case PLASTIK:
                fasadyPrice = 35000;
                break;
            case EMAL:
                fasadyPrice = 42000;
                break;
            case SHPON:
                fasadyPrice = 50000;
                break;
            case MASSIV:
                fasadyPrice = 55000;
                break;
        }

        switch (visota) {
            case SEMDVA:
                visotaKef = 1;
                break;
            case DEVYATNOL:
                visotaKef = 1.1;
                break;
            case DOPOTOLKA:
                visotaKef = 1.3;
                break;
        }

        switch (stoleshnica) {
            case PLASTIK:
                stoleshnicaPrice = 0;
                break;
            case KAMEN:
                stoleshnicaPrice = size * 0.6 * 23000 * 1.2;
                break;
        }

        switch (fartuk) {
            case PLITKA:
                fartukPrice = 0;
                break;
            case PLASTIK:
                fartukPrice = size * 3000;
                break;
            case KAMEN:
                fartukPrice = 0.6 * 21000 * 1.2;
                break;
        }

        switch (furnitura) {
            case BLUM:
                furnituraPrice = size * 3 * 800;
                yashikiPrice = yashiki * 2500;
                break;
            case BOYARD:
                furnituraPrice = 0;
                yashikiPrice = yashiki * 1000;
                break;
        }


      sum = size * fasadyPrice * visotaKef + stoleshnicaPrice + fartukPrice + furnituraPrice + yashikiPrice;

    if(sum<100000)
        discount = 0.15;
    else if (sum>=100000 && sum <150000)
        discount = 0.21;
    else if (sum>=150000 && sum<250000)
        discount = 0.25;
    else discount = 0.29;

    sumWithDiscount = sum*(1-discount);

    return sumWithDiscount;
    }


}

