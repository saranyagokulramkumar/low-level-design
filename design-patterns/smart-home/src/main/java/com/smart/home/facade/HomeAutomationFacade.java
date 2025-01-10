package com.smart.home.facade;

public class HomeAutomationFacade {
    private final Lights lights;
    private final Thermostat thermostat;
    private final SecurityCameras cameras;

    public HomeAutomationFacade(Lights lights, Thermostat thermostat, SecurityCameras cameras){
        this.lights = lights;
        this.thermostat = thermostat;
        this.cameras = cameras;
    }

    public void activateAllSystems(){
        System.out.println("Activating all systems...");
        lights.turnOn();
        thermostat.setTemperature(22);
        cameras.activate();
    }

    public void shutDownAllSystems(){
        System.out.println("Shutting down all systems...");
        lights.turnOff();
        thermostat.turnOff();
        cameras.deactivate();
    }
}
