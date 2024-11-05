package test.java.com.example.vending;

import com.example.vending.model.Item;
import com.example.vending.model.SnackItem;
import com.example.vending.observer.DisplayObserver;
import com.example.vending.service.ItemService;
import com.example.vending.service.PaymentService;
import com.example.vending.service.VendingMachineService;
import com.example.vending.strategy.CardPayment;
import com.example.vending.strategy.CoinPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VendingMachineServiceTest {

    @Mock
    private ItemService itemService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private DisplayObserver displayObserver;

    @InjectMocks
    private VendingMachineService vendingMachineService;

    private Item item;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        vendingMachineService.addObserver(displayObserver);
        item = new SnackItem("S1",1.5f, 10);
    }

    @Test
    void testSelectItem(){
        when(itemService.findItemByCode("S1")).thenReturn(Optional.of(item));

        String result = vendingMachineService.selectItem("S1");

        assertEquals("Selected item: S1, Price: 1.5", result);

        verify(displayObserver).update("Price: 1.5");
    }

    @Test
    void testInsertPaymentWithCoinPayment(){
        CoinPayment coinPayment = new CoinPayment();
        coinPayment.addPayment(1.0f);
        when(paymentService.getPaymentStrategy()).thenReturn(coinPayment);

        vendingMachineService.insertPayment(1.0f,"coin");

        verify(displayObserver).update("Balance: 1.0");
    }

    @Test
    void testInsertPaymentWithCardPayment(){
        CardPayment cardPayment = new CardPayment();
        cardPayment.addPayment(2.0f);

        when(paymentService.getPaymentStrategy()).thenReturn(cardPayment);

        vendingMachineService.insertPayment(2.0f, "card");

        verify(displayObserver).update("Balance: 2.0");
    }

    @Test
    void testCompleteTransactionSuccess(){
        when(itemService.findItemByCode("S1")).thenReturn(Optional.of(item));

        CoinPayment coinPayment = new CoinPayment();
        coinPayment.addPayment(1.5f);

        when(paymentService.getPaymentStrategy()).thenReturn(coinPayment);

        String result = vendingMachineService.completeTransaction("S1");

        assertEquals("Transaction complete. Dispensind item: S1", result);

        verify(itemService).decrementItemQuantity("S1");
        verify(displayObserver).update("Transaction complete");
    }

    @Test
    void testCompleteTransactionInsufficientFunds(){
        when(itemService.findItemByCode("S1")).thenReturn(Optional.of(item));
        CoinPayment coinPayment = new CoinPayment();
        coinPayment.addPayment(1.0f);

        when(paymentService.getPaymentStrategy()).thenReturn(coinPayment);

        String result = vendingMachineService.completeTransaction("S1");

        assertEquals("Insufficient funds.",result);
        verify(displayObserver).update("Insufficient funds.");
    }

    @Test
    void testCancelTransaction(){
        vendingMachineService.cancelTransation();

        verify(paymentService.getPaymentStrategy()).resetBalance();
        verify(displayObserver).update("Transaction canceled");
    }
}
