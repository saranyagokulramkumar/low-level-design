package com.smart.home.factory;

public class SmartLight implements Device{
    @Override
    public void turnOn() {
        System.out.println("Smart light is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart light is turned OFF.");
    }
}
