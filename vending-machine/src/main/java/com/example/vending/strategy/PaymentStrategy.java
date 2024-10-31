package com.example.vending.strategy;

public interface PaymentStrategy {
    void addPayment(float amount);
    float getBalance();
    void resetBalance();
    boolean processPayment(float amount);
}
