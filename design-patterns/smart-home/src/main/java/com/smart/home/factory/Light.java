package com.smart.home.factory;

public class Light implements Device{
    @Override
    public void turnOn(){
        System.out.println("Light is turned ON.");
    }

    @Override
    public void turnOff(){
        System.out.println("Light is turned OFF.");
    }
}
