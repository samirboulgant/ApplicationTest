package com.model;

import com.enums.CoinsEnum;
import com.enums.ProductsEnum;
import com.exceptions.InsuffisantCoinsInBalanceException;
import com.exceptions.InsuffisantPriceException;
import com.exceptions.InsuffisantStockException;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private HashMap<CoinsEnum,Integer> balance;
    private HashMap<ProductsEnum,Integer> stock;

    public VendingMachine(HashMap<CoinsEnum, Integer> balance, HashMap<ProductsEnum, Integer> stock) {
        this.balance = balance;
        this.stock = stock;
    }

    public HashMap<CoinsEnum, Integer> getBalance() {
        return balance;
    }

    public HashMap<ProductsEnum, Integer> getStock() {
        return stock;
    }


    public void setBalance(HashMap<CoinsEnum, Integer> balance) {
        this.balance = balance;
    }

    public void setStock(HashMap<ProductsEnum, Integer> stock) {
        this.stock = stock;
    }


    public void addStock(HashMap<ProductsEnum, Integer> stock){
        for ( ProductsEnum key : stock.keySet() ) {
            this.stock.put(key,this.stock.get(key)+stock.get(key));
        }
    }

    public void decreaseStock(ProductsEnum productsEnum) throws InsuffisantStockException {

        if(stock.get(productsEnum)<=0) throw new InsuffisantStockException("the product required is not in stock");

        else this.stock.put(productsEnum,this.stock.get(productsEnum)-1);

    }

    //this function is used when a user want a refund
    public void decreaseBalance(HashMap<CoinsEnum,Integer> coinsEnum){
        for(Map.Entry<CoinsEnum,Integer> set : balance.entrySet()){
            if(coinsEnum.containsKey(set.getKey())){
                this.balance.put(set.getKey(),this.balance.get(set.getKey())-coinsEnum.get(set.getKey()));
            }
        }
    }
    // add coins to the machine when someone buy a thing
    public void increaseBalance(HashMap<CoinsEnum,Integer> userInput){
        for(Map.Entry<CoinsEnum,Integer> set : balance.entrySet()){
            if(userInput.containsKey(set.getKey())){
                this.balance.put(set.getKey(),this.balance.get(set.getKey())+userInput.get(set.getKey()));
            }
        }

    }

    // add some coins by machine owner
    public void addBalance(HashMap<CoinsEnum, Integer> balance){
        for ( CoinsEnum key : balance.keySet()) {
            this.balance.put(key,this.balance.get(key)+balance.get(key));
        }
    }

    public void exchangeToUser(User user) throws InsuffisantCoinsInBalanceException, InsuffisantPriceException {
        HashMap<CoinsEnum, Integer> exchangeCoins =  user.exchangeMoney(this);
        for (Map.Entry<CoinsEnum, Integer> set :
                this.balance.entrySet()){
            if(exchangeCoins.containsKey(set.getKey())){
                this.balance.put(set.getKey(),this.balance.get(set.getKey())-exchangeCoins.get(set.getKey()));
            }
        }
    }

}
