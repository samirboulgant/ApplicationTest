package com.enums;

public enum ProductsEnum {
    MIRENDINA(2,"Mirendina"), TANGO(3,"Tango"), KITKAT(13,"KitKat"),
    SNICKERS(15,"Snickers"), MILKA(26,"Milka");


    private double price;
    private String label;


    ProductsEnum(double price, String label) {
        this.price=price;
        this.label=label;
    }

    public double getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }
}
