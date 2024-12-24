package com.smart.home.singleton;

// Singleton: Central Control Hub
public class ControlHub {
    private static ControlHub instance;

    private ControlHub(){
        // private constructor prevents instantiation
    }

    public static synchronized ControlHub getInstance(){
        if(instance == null){
            instance = new ControlHub();
        }
        return instance;
    }

    public void initialize(){
        System.out.println("Smart Home Control Hub Initialized!");
    }
}
