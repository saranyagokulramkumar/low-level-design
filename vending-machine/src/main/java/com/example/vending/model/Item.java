package com.example.vending.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
