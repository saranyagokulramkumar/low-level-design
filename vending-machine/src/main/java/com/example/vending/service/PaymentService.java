package com.example.vending.service;

import com.example.vending.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentStrategy paymentStrategy;

    @Autowired
    public PaymentService(@Qualifier("coinPayment") PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy; // default to coin payment
    }

    @Autowired
    @Qualifier("coinPayment")
    private PaymentStrategy coinPayment;

    @Autowired
    @Qualifier("cardPayment")
    private PaymentStrategy cardPayment;

    public void setPaymentStrategy(String type){

            if("coin".equalsIgnoreCase(type)){
                this.paymentStrategy = coinPayment;
            }else if("card".equalsIgnoreCase(type)){
                this.paymentStrategy = cardPayment;
            }else{
                throw new IllegalArgumentException("unknown payment type: "+type);
            }

    }

    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy;
    }
}
