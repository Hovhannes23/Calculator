package com.example.calculator.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Calculator implements Calculate {

    @Autowired
    Kitchen kitchen;

//    @Override
//    public Map<String, Integer> calculate(Kitchen kitchen) {
//        double sum = 0;
//        double sumWithDiscount = 0;
//        double fasadyPrice = 0;
//        double visotaKef = 1;
//        double stoleshnicaPrice = 0;
//        double fartukPrice = 0;
//        double furnituraPrice = 0;
//        double yashikiPrice = 0;
//        double discount = 0;
//        double sborka = 0;
//
//        switch (kitchen.getFasady()) {
//            case PLYONKA:
//                fasadyPrice = 28000;
//                break;
//            case PLASTIK:
//                fasadyPrice = 35000;
//                break;
//            case EMAL:
//                fasadyPrice = 42000;
//                break;
//            case SHPON:
//                fasadyPrice = 50000;
//                break;
//            case MASSIV:
//                fasadyPrice = 55000;
//                break;
//        }
//
//        switch (visota) {
//            case SEMDVA:
//                visotaKef = 1;
//                break;
//            case DEVYATNOL:
//                visotaKef = 1.1;
//                break;
//            case DOPOTOLKA:
//                visotaKef = 1.3;
//                break;
//        }
//
//        switch (stoleshnica) {
//            case PLASTIK:
//                stoleshnicaPrice = 0;
//                break;
//            case KAMEN:
//                stoleshnicaPrice = size * 0.6 * 23000 * 1.2;
//                break;
//        }
//
//        switch (fartuk) {
//            case PLITKA:
//                fartukPrice = 0;
//                break;
//            case PLASTIK:
//                fartukPrice = size * 3000;
//                break;
//            case KAMEN:
//                fartukPrice = 0.6 * 21000 * 1.2;
//                break;
//        }
//
//        switch (furnitura) {
//            case BLUM:
//                furnituraPrice = size * 3 * 800;
//                yashikiPrice = yashiki * 2500;
//                break;
//            case BOYARD:
//                furnituraPrice = 0;
//                yashikiPrice = yashiki * 1000;
//                break;
//        }
//
//
//        sum = size * fasadyPrice * visotaKef + stoleshnicaPrice + fartukPrice + furnituraPrice + yashikiPrice;
//
//        if(sum<100000)
//            discount = 0.15;
//        else if (sum>=100000 && sum <150000)
//            discount = 0.21;
//        else if (sum>=150000 && sum<250000)
//            discount = 0.25;
//        else discount = 0.29;
//
//        int discountSum = (int)(sum*discount);
//        sumWithDiscount = sum*(1-discount);
//        sborka = sumWithDiscount*0.1;
//
//        Map<String,Integer> priceAndDiscount = new HashMap<>();
//        priceAndDiscount.put("sum",(int)sum);
//        priceAndDiscount.put("discount",discountSum);
//        priceAndDiscount.put("sumWithDiscount",(int)sumWithDiscount);
//        priceAndDiscount.put("stoleshnicaPrice",(int)stoleshnicaPrice);
//        priceAndDiscount.put("fartukPrice",(int)fartukPrice);
//        priceAndDiscount.put("furnituraPrice",(int)furnituraPrice);
//        priceAndDiscount.put("yashikiPrice",(int)yashikiPrice);
//        priceAndDiscount.put("sborka",(int)sborka);
//
//        return priceAndDiscount;
//    }


    @Override
    public Map<String,Integer> calculate(double size, Fasady fasady, Visota visota,
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
        double sborka = 0;

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

    int discountSum = (int)(sum*discount);
    sumWithDiscount = sum*(1-discount);
    sborka = sumWithDiscount*0.1;

    Map<String,Integer> priceAndDiscount = new HashMap<>();
    priceAndDiscount.put("sum",(int)sum);
    priceAndDiscount.put("discount",discountSum);
    priceAndDiscount.put("sumWithDiscount",(int)sumWithDiscount);
    priceAndDiscount.put("stoleshnicaPrice",(int)stoleshnicaPrice);
    priceAndDiscount.put("fartukPrice",(int)fartukPrice);
    priceAndDiscount.put("furnituraPrice",(int)furnituraPrice);
    priceAndDiscount.put("yashikiPrice",(int)yashikiPrice);
    priceAndDiscount.put("sborka",(int)sborka);

    return priceAndDiscount;
    }

}


