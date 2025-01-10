package com.smart.home.facade;

import org.junit.jupiter.api.Test;

public class FacadePatternTest {
    @Test
    public void testFacadePattern(){
        Lights lights = new Lights();
        Thermostat thermostat = new Thermostat();
        SecurityCameras cameras = new SecurityCameras();

        HomeAutomationFacade facade = new HomeAutomationFacade(lights, thermostat, cameras);
        facade.activateAllSystems();
        System.out.println();
        facade.shutDownAllSystems();
    }
}
