package com.smart.home.builder;

public class StandardTVDirector implements SmartTVDirector{
    @Override
    public SmartTV createSmartTV() {
        return new SmartTV.Builder()
                .setScreenSize("40 inches")
                .setResolution("1080p")
                .enableVoiceControl(false)
                .setStreamingApps(new String[]{"Netflix"})
                .build();
    }
}
