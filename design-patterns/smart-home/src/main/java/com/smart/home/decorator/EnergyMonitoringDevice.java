package com.smart.home.decorator;
// Concrete decorator
public class EnergyMonitoringDevice extends DeviceDecorator{
    public EnergyMonitoringDevice(Device device){
        super(device);
    }

    public void monitorEnergyUsage(){
        System.out.println("Monitoring energy usage...");
    }

    @Override
    public void turnOn(){
        System.out.println("Starting energy monitoring...");
        super.turnOn();
    }
}
