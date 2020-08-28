package com.example.calculator.models;

public enum Furnitura {
    BLUM("Blum(Австрия)"), BOYARD("Boyard(Россия)");

    private String furnitura;

    Furnitura(String furnitura) {
        this.furnitura = furnitura;
    }

    public String getFurnitura() {
        return furnitura;
    }

    public void setFurnitura(String furnitura) {
        this.furnitura = furnitura;
    }

    public static Furnitura getFurnituraByName(String name) {
        for (Furnitura fur : values()) {
            if (fur.getFurnitura().equals(name)) {
                return fur;
            }
        }
        throw new IllegalArgumentException("No enum found with name: [" + name + "]");
    }
}
