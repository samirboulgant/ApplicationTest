package com.main;

import com.enums.CoinsEnum;
import com.enums.ProductsEnum;
import com.exceptions.InsuffisantCoinsInBalanceException;
import com.model.User;
import com.model.VendingMachine;

import java.util.HashMap;

public class Main {


    // this main just to verify some functions
    public static void main(String args[]) throws InsuffisantCoinsInBalanceException {
        int rest=13;
        int numberOfCoin;
        HashMap<CoinsEnum,Integer> coinsEnums = new HashMap<>();
        HashMap<ProductsEnum,Integer> productEnum = new HashMap<>();
        User user;
        VendingMachine machine;
        HashMap<CoinsEnum,Integer> exchangeCoin = new HashMap<>();


        for (CoinsEnum coinsEnum : CoinsEnum.values()) {
            coinsEnums.put(coinsEnum, 10);
        }
        for (ProductsEnum productsEnum : ProductsEnum.values()) {
            productEnum.put(productsEnum,10);
        }
        coinsEnums.put(CoinsEnum.TWO_DIRHAMS,0);
        coinsEnums.put(CoinsEnum.DIRHAM,0);
        machine = new VendingMachine(coinsEnums,productEnum);

        for (CoinsEnum coinsEnum : CoinsEnum.values()) {
            double check=rest;
            if(rest>=coinsEnum.getPrice()){
                numberOfCoin = (int) Math.floor(rest/coinsEnum.getPrice());
                rest = (int) (rest%coinsEnum.getPrice());
                try {
                    if(machine.getBalance().get(coinsEnum) < numberOfCoin && coinsEnum.getPrice()>1)  rest = (int) check;
                    else if(machine.getBalance().get(coinsEnum) < numberOfCoin ){
                        throw new InsuffisantCoinsInBalanceException("Sorry insufficient coins in our balance");
                    }
                    else {
                        exchangeCoin.put(coinsEnum,numberOfCoin);
                    }
                } catch(Exception e){
                    exchangeCoin.replaceAll((key,value)-> value=0);
                    System.out.println("refund afforded");
                }
            }
            else continue;
            if(rest==0) break;
        }
        exchangeCoin.forEach((k,v)->System.out.println("key:"+k+"value"+v));
    }
}
