package com.example.vending.observer;

public class Display implements DisplayObserver{
    @Override
    public void update(String message){
        System.out.println("Display: "+message);
    }
}
