package com.example.vending.config;

import com.example.vending.strategy.CardPayment;
import com.example.vending.strategy.CoinPayment;
import com.example.vending.strategy.PaymentStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VendingMachineConfig {

    @Bean("coinPayment")
    public PaymentStrategy coinPayment(){
        return new CoinPayment();
    }

    @Bean("cardPayment")
    public PaymentStrategy cardPayment(){
        return new CardPayment();
    }
}
