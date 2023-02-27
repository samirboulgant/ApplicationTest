package com.enums;

public enum CoinsEnum {

    TEN_DIRHAMS(10,"Ten dirham"),FIVE_DIRHAMS(5,"Five dirham"), TWO_DIRHAMS(2,"Two dirham"),DIRHAM(1,"One dirham"),HALF_DIRHAM(0.5,"Half of dirham");

    public double price;
    public String label;

    CoinsEnum(double price, String label) {
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
