package com.smart.home.factory;

import org.junit.jupiter.api.Test;

public class AbstractFactoryMethodPatternTest {
    @Test
    public void testAbstractFactoryMethodPattern(){
        DeviceFamilyFactory smartFactory = new SmartDeviceFamily();
        Device smartFan = smartFactory.createFan();
        Device smartLight = smartFactory.createLight();
        smartFan.turnOn();
        smartFan.turnOff();
        smartLight.turnOn();
        smartLight.turnOff();

        DeviceFamilyFactory nonSmartFactory = new NonSmartDeviceFamily();
        Device light = nonSmartFactory.createLight();
        Device fan = nonSmartFactory.createFan();

        light.turnOn();
        light.turnOff();
        fan.turnOn();
        fan.turnOff();
    }
}
