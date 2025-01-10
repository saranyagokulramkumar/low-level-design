package com.smart.home.facade;

//Subsystem: Thermostat
public class Thermostat {
    public void setTemperature(int temperature){
        System.out.println("Thermostat set to "+temperature+" degrees.");
    }

    public void turnOff(){
        System.out.println("Thermostat is turned OFF.");
    }
}
