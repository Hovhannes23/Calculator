package com.example.calculator.models;

import java.util.List;
import java.util.Map;

public interface Calculate {

    Map<String, Integer> calculate(double size, Fasady fasady, Visota visota,
                                   Stoleshnica stoleshnica, Fartuk fartuk,
                                   Furnitura furnitura, int yashiki);


//    Map<String, Integer> calculate(Kitchen kitchen);
//
}