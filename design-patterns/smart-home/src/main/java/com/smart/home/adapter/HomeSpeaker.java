package com.smart.home.adapter;

public class HomeSpeaker {
    public void powerOn(){
        System.out.println("HomeSpeaker is powered ON.");
    }

    public void powerOff(){
        System.out.println("HomeSpeaker is powered OFF.");
    }

    public void setVolume(int level){
        System.out.println("HomeSpeaker volume is set to "+ level);
    }
}
