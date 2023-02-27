package com.user.test;

import com.enums.CoinsEnum;
import com.enums.ProductsEnum;
import com.exceptions.InsuffisantCoinsInBalace;
import com.exceptions.InsuffisantPriceException;
import com.exceptions.InsuffisantStockException;
import com.model.User;
import com.model.VendingMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class buyProductTest {
    HashMap<CoinsEnum,Integer> coinsEnums = new HashMap<>();
    HashMap<ProductsEnum,Integer> productEnum = new HashMap<>();
    User user;
    User user1;
    VendingMachine vendingMachine;

    @BeforeAll
    public void setUp(){
        for (CoinsEnum coinsEnum : CoinsEnum.values()) {
            coinsEnums.put(coinsEnum, 10);
        }
        for (ProductsEnum productsEnum : ProductsEnum.values()) {
            productEnum.put(productsEnum,10);
        }
        productEnum.put(ProductsEnum.MIRENDINA,0);
        vendingMachine = new VendingMachine(coinsEnums,productEnum);
        HashMap<CoinsEnum,Integer> coins = new HashMap<>();
        coins.put(CoinsEnum.TEN_DIRHAMS,1);
        HashMap<CoinsEnum,Integer> userCoins = new HashMap<>();
        user = new User(coins,ProductsEnum.TANGO);
        user1 = new User(coins,ProductsEnum.MIRENDINA);
    }

     @Test
     public void buyProductTest() throws InsuffisantCoinsInBalace, InsuffisantStockException, InsuffisantPriceException {
         user.buyProduct(vendingMachine);
         Assertions.assertEquals(vendingMachine.getBalance().get(CoinsEnum.TEN_DIRHAMS),11);
         Assertions.assertEquals(vendingMachine.getBalance().get(CoinsEnum.FIVE_DIRHAMS),9);
         Assertions.assertEquals(vendingMachine.getBalance().get(CoinsEnum.DIRHAM),10);
         Assertions.assertEquals(vendingMachine.getBalance().get(CoinsEnum.TWO_DIRHAMS),9);
         Assertions.assertEquals(vendingMachine.getStock().get(ProductsEnum.TANGO),9);
     }

     @Test
     public void shouldThrowInsuffisantStockException(){
         Assertions.assertThrows(InsuffisantStockException.class,()->user1.buyProduct(vendingMachine));
     }


}
