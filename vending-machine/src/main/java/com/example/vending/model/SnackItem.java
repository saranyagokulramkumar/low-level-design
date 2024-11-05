package com.example.vending.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SnackItem extends Item{
    public SnackItem(String code, float price, int quantity){
        super(code, price, quantity);
    }
}
