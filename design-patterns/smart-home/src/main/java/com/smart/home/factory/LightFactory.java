package com.smart.home.factory;

public class LightFactory implements DeviceFactory{
    @Override
    public Device createDevice() {
        return new Light();
    }
}
