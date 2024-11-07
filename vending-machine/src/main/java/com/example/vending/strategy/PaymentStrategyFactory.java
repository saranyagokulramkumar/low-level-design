package com.example.vending.strategy;

import com.example.vending.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentStrategyFactory {
    private final Map<String, PaymentStrategy> paymentStrategyMap;

    @Autowired
    public PaymentStrategyFactory(@Qualifier("coinPayment") PaymentStrategy coinPayment,
                                  @Qualifier("cardPayment") PaymentStrategy cardPayment){
        this.paymentStrategyMap = Map.of("coin", coinPayment, "card", cardPayment);
    }

    public PaymentStrategy getPaymentStrategy(String type){
        PaymentStrategy strategy = paymentStrategyMap.get(type.toLowerCase());

        if(strategy == null){
            throw new IllegalArgumentException("Unknown payment type: "+type);
        }
        return strategy;
    }
}
