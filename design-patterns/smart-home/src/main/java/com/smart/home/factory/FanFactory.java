package com.smart.home.factory;

public class FanFactory implements DeviceFactory{
    @Override
    public Device createDevice() {
        return new Fan();
    }
}
