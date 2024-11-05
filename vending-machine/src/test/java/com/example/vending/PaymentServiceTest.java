package test.java.com.example.vending;

import com.example.vending.service.PaymentService;
import com.example.vending.strategy.CardPayment;
import com.example.vending.strategy.CoinPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentServiceTest {

    @Mock
    private CoinPayment coinPayment;

    @Mock
    private CardPayment cardPayment;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
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
