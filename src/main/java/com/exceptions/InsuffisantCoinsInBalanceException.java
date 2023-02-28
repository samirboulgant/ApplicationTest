package com.exceptions;

public class InsuffisantCoinsInBalanceException extends Exception{
    public InsuffisantCoinsInBalanceException(String msg){
        super(msg);
    }
}
