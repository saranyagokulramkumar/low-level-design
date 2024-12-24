package com.smart.home.factory;

public class SmartFan implements Device{
    @Override
    public void turnOn() {
        System.out.println("Smart fan is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart fan is turned OFF.");
    }
}
