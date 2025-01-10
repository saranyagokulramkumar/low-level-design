package com.smart.home.decorator;

import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {
    @Test
    public void testDecoratorPattern(){
        Device light = new Light("Living room light");

        // add scheduling functionality to light
        Device scheduledLight = new ScheduledDevice(light);
        scheduledLight.turnOn();
        ((ScheduledDevice)scheduledLight).schedule("6:00 PM");

        System.out.println();

        // add energy monitoring functionality to scheduled light
        Device energyMonitoringLight = new EnergyMonitoringDevice(scheduledLight);
        energyMonitoringLight.turnOn();

        ((EnergyMonitoringDevice)energyMonitoringLight).monitorEnergyUsage();
    }
}
