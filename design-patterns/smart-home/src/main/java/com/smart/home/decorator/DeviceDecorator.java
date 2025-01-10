package com.smart.home.decorator;
// Base decorator
public abstract class DeviceDecorator implements Device{
    protected final Device decoratedDevice;

    protected DeviceDecorator(Device device){
        this.decoratedDevice = device;
    }

    @Override
    public void turnOn(){
        decoratedDevice.turnOn();
    }

    @Override
    public void turnOff(){
        decoratedDevice.turnOff();
    }
}
