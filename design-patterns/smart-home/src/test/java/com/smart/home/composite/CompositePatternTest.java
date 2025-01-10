package com.smart.home.composite;

import org.junit.jupiter.api.Test;

public class CompositePatternTest {
    @Test
    public void testCompositePattern(){
        Device light1 = new Device("Living room light");
        Device fan1 = new Device("Living room fan");
        Device light2 = new Device( "Bedroom light");
        Device fan2 = new Device("Bedroom fan");

        DeviceGroup livingRoomGroup = new DeviceGroup("Living room devices");
        livingRoomGroup.addDevice(light1);
        livingRoomGroup.addDevice(fan1);

        DeviceGroup bedRoomGroup = new DeviceGroup("Bedroom devices");
        bedRoomGroup.addDevice(light2);
        bedRoomGroup.addDevice(fan2);

        DeviceGroup houseGroup = new DeviceGroup("House devices");
        houseGroup.addDevice(livingRoomGroup);
        houseGroup.addDevice(bedRoomGroup);

        houseGroup.turnOn();
        System.out.println();
        houseGroup.turnOff();
    }
}
