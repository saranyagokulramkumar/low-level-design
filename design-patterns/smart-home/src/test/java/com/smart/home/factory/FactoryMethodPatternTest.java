package com.smart.home.factory;

import org.junit.jupiter.api.Test;

public class FactoryMethodPatternTest {
    @Test
    public void testFactoryMethodPatter(){
        DeviceFactory deviceFactory = new LightFactory();
        Device light = deviceFactory.createDevice();
        light.turnOn();
        light.turnOff();

        deviceFactory = new FanFactory();
        Device fan = deviceFactory.createDevice();
        fan.turnOn();
        fan.turnOff();
    }
}
