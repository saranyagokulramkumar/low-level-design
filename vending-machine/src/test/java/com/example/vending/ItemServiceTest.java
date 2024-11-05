package test.java.com.example.vending;

import com.example.vending.model.Item;
import com.example.vending.model.SnackItem;
import com.example.vending.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemServiceTest {

    private ItemService itemService;
    private Item item;

    @BeforeEach
    void setUp(){
        itemService = new ItemService();
        item = new SnackItem("S1",1.5f,10);
        itemService.addItem(item);
    }

    @Test
    void testAddItem(){
        Optional<Item> foundItem = itemService.findItemByCode("S1");
        assertTrue(foundItem.isPresent());
        assertEquals("S1", foundItem.get().getCode());
    }

    @Test
    void testFindItemByCode(){
        Optional<Item> foundItem = itemService.findItemByCode("S1");
        assertTrue(foundItem.isPresent());
    }

    @Test
    void testDecrementItemQuantity(){
        boolean result = itemService.decrementItemQuantity("S1");
        assertTrue(result);
        assertEquals(9,item.getQuantity());
    }
}
