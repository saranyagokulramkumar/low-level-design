package com.smart.home.factory;

public class Fan implements Device{
    @Override
    public void turnOn(){
        System.out.println("Fan is turned ON.");
    }

    @Override
    public void turnOff(){
        System.out.println("Fan is turned OFF.");
    }
}
