package com.example.vending.service;

import com.example.vending.model.Item;
import com.example.vending.observer.DisplayObserver;
import com.example.vending.observer.Subject;
import com.example.vending.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendingMachineService implements Subject {

    private final List<DisplayObserver> observers = new ArrayList<>();
    private final ItemService itemService;
    private final PaymentService paymentService;

    @Autowired
    public VendingMachineService(ItemService itemService, PaymentService paymentService){
        this.itemService = itemService;
        this.paymentService = paymentService;
    }

    @Override
    public void addObserver(DisplayObserver observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(DisplayObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message){
        observers.forEach(observer -> observer.update(message));
    }

    public void addItem(Item item){
        itemService.addItem(item);
    }

    public String selectItem(String itemCode){
        Optional<Item> item = itemService.findItemByCode(itemCode);

        if(item.isEmpty()){
            notifyObservers("Invalid item code");
            return "Invalid item code";
        }

        if(item.get().getQuantity() == 0){
            notifyObservers("Item out of stock");
            return "Item out of stock";
        }

        notifyObservers("Price: " + item.get().getPrice());
        return "Selected item: "+item.get().getCode() + ", Price: "+item.get().getPrice();
    }

    public String insertPayment(float amount, String paymentType){
        try{
            paymentService.setPaymentStrategy(paymentType);
            paymentService.getPaymentStrategy().addPayment(amount);
            float currentBalance = paymentService.getPaymentStrategy().getBalance();
            notifyObservers("Balance: "+currentBalance);
            return "Current balance: "+ currentBalance;
        }catch(IllegalArgumentException e){
            notifyObservers(e.getMessage());
            return e.getMessage();
        }
    }

    public String completeTransaction(String itemCode){
        Optional<Item> item = itemService.findItemByCode(itemCode);
        if(item.isEmpty()){
            notifyObservers("Invalid item code");
            return "Invalid item code";
        }

        if(item.get().getQuantity() == 0){
            notifyObservers("Item out of stock");
            return "Item out of stock";
        }

        if(!paymentService.getPaymentStrategy().processPayment(item.get().getPrice())){
            notifyObservers("Insufficient funds");
            return "Insufficient funds";
        }
        itemService.decrementItemQuantity(itemCode);
        notifyObservers("Transaction complete");
        return "Transaction complete. Dispensing item: "+item.get().getCode();
    }

    public String cancelTransation(){
        paymentService.getPaymentStrategy().resetBalance();
        notifyObservers("Transaction canceled");
        return "Transaction canceled.";
    }
}
