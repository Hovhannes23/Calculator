package com.example.calculator.models;

public enum Fartuk { PLITKA("плитка"),
                     PLASTIK("пластик"),
                     KAMEN("искусственный камень");

private String fartuk;

Fartuk(String fartuk) {

    this.fartuk = fartuk;
}

    public String getFartuk() {
        return fartuk;
    }

    public void setFartuk(String fartuk) {
        this.fartuk = fartuk;
    }

    public static Fartuk getFartukByName(String name) {
        for (Fartuk fr : values()) {
            if (fr.getFartuk().equals(name)) {
                return fr;
            }
        }
        throw new IllegalArgumentException("No enum found with name: [" + name + "]");
    }

}
