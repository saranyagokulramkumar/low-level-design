package com.example.vending.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DrinkItem extends Item{
    public DrinkItem(String code, float price, int quantity){
        super(code, price, quantity);
    }
}
