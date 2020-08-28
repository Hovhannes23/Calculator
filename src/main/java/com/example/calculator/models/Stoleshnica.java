package com.example.calculator.models;

public enum Stoleshnica { PLASTIK("пластик"),
                          KAMEN("искусственный камень");

private String stoleshnica;

Stoleshnica(String stoleshnica){
    this.stoleshnica=stoleshnica;
}

    public String getStoleshnica() {
        return stoleshnica;
    }

    public void setStoleshnica(String stoleshnica) {
        this.stoleshnica = stoleshnica;
    }

    public static Stoleshnica getStoleshnicaByName(String name) {
        for (Stoleshnica st : values()) {
            if (st.getStoleshnica().equals(name)) {
                return st;
            }
        }
        throw new IllegalArgumentException("No enum found with name: [" + name + "]");
    }
}

