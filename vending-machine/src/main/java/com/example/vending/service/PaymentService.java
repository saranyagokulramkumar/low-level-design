package com.example.vending.service;

import com.example.vending.strategy.PaymentStrategy;
import com.example.vending.strategy.PaymentStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentStrategy paymentStrategy;

    private final PaymentStrategyFactory paymentStrategyFactory;

    @Autowired
    public PaymentService(PaymentStrategyFactory paymentStrategyFactory){
        this.paymentStrategyFactory = paymentStrategyFactory;
    }

    public void setPaymentStrategy(String type){
        this.paymentStrategy = paymentStrategyFactory.getPaymentStrategy(type);
    }

    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy;
    }
}
