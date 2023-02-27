package com.main;

import com.enums.CoinsEnum;
import com.enums.ProductsEnum;
import com.exceptions.InsuffisantCoinsInBalace;
import com.model.User;
import com.model.VendingMachine;

import java.util.HashMap;

public class Main {

    public static void main(String args[]) throws InsuffisantCoinsInBalace {
        int rest=7;
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
        machine = new VendingMachine(coinsEnums,productEnum);

        for (CoinsEnum coinsEnum : CoinsEnum.values()) {
            if(rest>=coinsEnum.getPrice()){
                numberOfCoin = (int) Math.floor(rest/coinsEnum.getPrice());
                System.out.println(coinsEnum.getPrice());
                rest = (int) (rest%coinsEnum.getPrice());
                if(machine.getBalance().get(coinsEnum) < numberOfCoin ){
                    throw new InsuffisantCoinsInBalace("Sorry insufficient coins in our balance");
                }
                else {
                    exchangeCoin.put(coinsEnum,numberOfCoin);
                }
            }
            else continue;
            if(rest==0) break;
        }
        exchangeCoin.forEach((k,v)->System.out.println("key:"+k+"value"+v));
    }
}
