package com.example.calculator.models;

public enum Visota {SEMDVA("72 см"),
                    DEVYATNOL("90 см"),
                    DOPOTOLKA("до потолка");

private String height;

 Visota(String height){

     this.height=height;
}

    public String getHeight() {

     return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public static Visota getVisotaByHeight(String height) {
        for (Visota vis : values()) {
            if (vis.getHeight().equals(height)) {
                return vis;
            }
        }
        throw new IllegalArgumentException("No enum found with name: [" + height + "]");
    }
}


