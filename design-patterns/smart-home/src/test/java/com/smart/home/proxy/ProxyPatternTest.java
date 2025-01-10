package com.smart.home.proxy;

import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    @Test
    public void testProxyPatter(){
        RealDevice securityCamera = new RealDevice("Security Camera");

        Device adminProxy = new DeviceProxy(securityCamera, "Admin");
        adminProxy.turnOn();
        adminProxy.turnOff();

        System.out.println();

        Device guestProxy = new DeviceProxy(securityCamera, "Guest");
        guestProxy.turnOn();
        guestProxy.turnOff();
    }
}
