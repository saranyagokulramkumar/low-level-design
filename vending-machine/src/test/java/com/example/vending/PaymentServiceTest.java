package com.example.vending;

import com.example.vending.service.PaymentService;
import com.example.vending.strategy.PaymentStrategyFactory;
import com.example.vending.strategy.CardPayment;
import com.example.vending.strategy.CoinPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {

    @Mock
    private CoinPayment coinPayment;

    @Mock
    private CardPayment cardPayment;

    @Mock
    private PaymentStrategyFactory paymentStrategyFactory;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        when(paymentStrategyFactory.getPaymentStrategy("coin")).thenReturn(coinPayment);
        when(paymentStrategyFactory.getPaymentStrategy("card")).thenReturn(cardPayment);
    }

    @Test
    void testSetCoinPaymentStrategy(){

        paymentService.setPaymentStrategy("coin");
        assertTrue(paymentService.getPaymentStrategy() instanceof CoinPayment);
    }

    @Test
    void testSetCardPaymentStrategy(){
        paymentService.setPaymentStrategy("card");
        assertTrue(paymentService.getPaymentStrategy() instanceof CardPayment);
    }
}
