package com.example.vending.strategy;

public class AbstractPayment implements PaymentStrategy{
    private float balance = 0;
    @Override
    public void addPayment(float amount){
        balance += amount;
    }

    @Override
    public float getBalance(){
        return balance;
    }
    @Override
    public void resetBalance(){
        balance = 0;
    }

    @Override
    public boolean processPayment(float amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
