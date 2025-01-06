package com.smart.home.adapter;

import com.smart.home.factory.Device;

public class HomeSpeakerAdapter implements Device {
    private final HomeSpeaker homeSpeaker;

    public HomeSpeakerAdapter(HomeSpeaker homeSpeaker){
        this.homeSpeaker = homeSpeaker;
    }
    @Override
    public void turnOn() {
        homeSpeaker.powerOn();
        homeSpeaker.setVolume(50);
    }

    @Override
    public void turnOff() {
        homeSpeaker.powerOff();
    }
}
