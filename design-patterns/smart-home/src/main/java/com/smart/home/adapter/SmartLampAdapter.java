package com.smart.home.adapter;

import com.smart.home.factory.Device;

public class SmartLampAdapter implements Device {
    private final SmartLamp smartLamp;

    public SmartLampAdapter(SmartLamp smartLamp){
        this.smartLamp = smartLamp;
    }
    @Override
    public void turnOn() {
        smartLamp.switchON();
    }

    @Override
    public void turnOff() {
        smartLamp.switchOFF();
    }
}
