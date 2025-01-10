package com.smart.home.composite;
// Lead: individual device
public class Device implements DeviceComponent{
    private final String name;

    public Device(String name){
        this.name = name;
    }
    @Override
    public void turnOn() {
        System.out.println(name +" is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(name +" is turned OFF.");
    }
}
