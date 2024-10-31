package com.example.vending.model;
import lombok.Data;

@Data
public abstract class Item {
    private String code;
    private float price;
    private int quantity;

    public void decrementQuantity(){
        if(quantity < 1){
            throw new IllegalArgumentException("Item out of stock: "+this.getCode());
        }
        quantity--;
    }
}
