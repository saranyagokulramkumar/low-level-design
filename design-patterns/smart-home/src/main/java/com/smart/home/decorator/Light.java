package com.smart.home.decorator;
// Concrete component
public class Light implements Device{
    private final String name;

    public Light(String name){
        this.name = name;
    }
    @Override
    public void turnOn() {
        System.out.println(name + " is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is turned OFF.");
    }
}
