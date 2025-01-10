package com.smart.home.decorator;
// Concerete Decorator
public class ScheduledDevice extends DeviceDecorator {
    public ScheduledDevice(Device device){
        super(device);
    }

    public void schedule(String time){
        System.out.println("Device scheduled to turn ON at: "+ time);
    }

    @Override
    public void turnOn(){
        System.out.println("Checking schedule before turning ON...");
        super.turnOn();
    }
}
