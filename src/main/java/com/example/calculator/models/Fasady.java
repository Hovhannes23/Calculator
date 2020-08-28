package com.example.calculator.models;

public enum Fasady { PLYONKA("Пленка ПВХ"),
                     PLASTIK("Пластик HPL"),
                     EMAL("Эмаль"),
                     SHPON("Шпон"),
                     MASSIV("Массив");

private String fasady;

Fasady(String fasady){
    this.fasady = fasady;

}


    public String getFasady() {
        return fasady;
    }

    public void setFasady(String fasady) {
        this.fasady = fasady;
    }

    public static Fasady getFasadyByName(String name) {
        for (Fasady fs : values()) {
            if (fs.getFasady().equals(name)) {
                return fs;
            }
        }
        throw new IllegalArgumentException("No enum found with name: [" + name + "]");
    }
}

