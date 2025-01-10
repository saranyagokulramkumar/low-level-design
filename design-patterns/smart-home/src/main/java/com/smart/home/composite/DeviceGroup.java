package com.smart.home.composite;

import java.util.ArrayList;
import java.util.List;

//Composite: Group of Devices
public class DeviceGroup implements DeviceComponent {
    private final String groupName;
    private final List<DeviceComponent> components = new ArrayList<>();

    public DeviceGroup(String groupName){
        this.groupName = groupName;
    }

    public void addDevice(DeviceComponent component){
        components.add(component);
    }

    public void removeDevice(DeviceComponent component){
        components.remove(component);
    }
    @Override
    public void turnOn() {
        System.out.println(groupName + " group is being turned ON.");
        for (DeviceComponent component : components) {
            component.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println(groupName + " group is being turned OFF.");
        for(DeviceComponent component : components){
            component.turnOff();
        }
    }
}
