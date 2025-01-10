package com.smart.home.proxy;

public class DeviceProxy implements Device{

    private final RealDevice realDevice;
    private final String userRole;

    public DeviceProxy(RealDevice realDevice, String userRole) {
        this.realDevice = realDevice;
        this.userRole = userRole;
    }

    private boolean hasAccess(){
        return "Admin".equalsIgnoreCase(userRole); // only admin has access
    }

    @Override
    public void turnOn() {
        if(hasAccess()){
            realDevice.turnOn();
        }else{
            System.out.println("Access Denied: You do not have permission to turn on this device.");
        }
    }

    @Override
    public void turnOff() {
        if(hasAccess()){
            realDevice.turnOff();
        }else{
            System.out.println("Access Denied: You do not have permission to turn off this device.");
        }
    }
}
