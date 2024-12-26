package com.smart.home.builder;

import com.smart.home.factory.Device;

public class SmartTV implements Device {
    private String screenSize;
    private String resolution;
    private boolean voiceControlEnabled;
    private String[] streamingApps;

    // private constructor to force usage of builder
    private SmartTV(){}

    @Override
    public void turnOn() {
        System.out.println("SmartTV turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartTV turned OFF.");
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public boolean isVoiceControlEnabled() {
        return voiceControlEnabled;
    }

    public String[] getStreamingApps() {
        return streamingApps;
    }

    // Builder: Inner static class
    public static class Builder{
        private final SmartTV tv;

        public Builder(){
            tv = new SmartTV();
        }

        public Builder setScreenSize(String screenSize){
            tv.screenSize = screenSize;
            return this;
        }

        public Builder setResolution(String resolution){
            tv.resolution = resolution;
            return this;
        }

        public Builder enableVoiceControl(boolean enabled){
            tv.voiceControlEnabled = enabled;
            return this;
        }

        public Builder setStreamingApps(String[] apps){
            tv.streamingApps = apps;
            return this;
        }

        public SmartTV build(){
            return tv;
        }
    }
}
