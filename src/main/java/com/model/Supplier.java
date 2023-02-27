package com.model;

import com.enums.CoinsEnum;
import com.enums.ProductsEnum;

import java.util.HashMap;

public class Supplier {

    private HashMap<ProductsEnum,Double> stock;
    private HashMap<CoinsEnum,Double> coins;


    public Supplier(HashMap<ProductsEnum, Double> stock) {
        this.stock = stock;
    }

    public HashMap<ProductsEnum, Double> getStock() {
        return stock;
    }

    public void setStock(HashMap<ProductsEnum, Double> stock) {
        this.stock = stock;
    }
    public void setBalance(HashMap<CoinsEnum, Double> coins) {
        this.coins = coins;
    }

}
