package com.example.vending.service;

import com.example.vending.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    private final Map<String, Item> items = new HashMap<>();

    // add an item to the inventory
    public void addItem(Item item){
        items.put(item.getCode(), item);
    }

    // retrieve an item by code
    public Optional<Item> findItemByCode(String code){
        return Optional.ofNullable(items.get(code));
    }

    // reduce quantity of an item after a purchase
    public boolean decrementItemQuantity(String code){
        Item item = items.get(code);
        if(item != null && item.getQuantity() > 0){
            item.decrementQuantity();
            return true;
        }
        return false;
    }

    // list all items
    public Map<String, Item> listAllItems(){
        return items;
    }
}
