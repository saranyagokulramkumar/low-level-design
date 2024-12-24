package com.smart.home.factory;

public class SmartDeviceFamily implements DeviceFamilyFactory{
    @Override
    public Device createLight() {
        return new SmartLight();
    }

    @Override
    public Device createFan() {
        return new SmartFan();
    }
}
