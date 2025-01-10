package com.smart.home.proxy;

public class RealDevice implements Device{
    private final String name;

    public RealDevice(String name) {
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
