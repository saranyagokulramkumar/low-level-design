package com.smart.home.factory;

public class NonSmartDeviceFamily implements DeviceFamilyFactory{
    @Override
    public Device createLight() {
        return new Light();
    }

    @Override
    public Device createFan() {
        return new Fan();
    }
}
