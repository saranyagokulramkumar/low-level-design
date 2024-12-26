package com.smart.home.builder;

public class GamingTVDirector implements SmartTVDirector{
    @Override
    public SmartTV createSmartTV() {
        return new SmartTV.Builder()
                .setScreenSize("55 inches")
                .setResolution("4K")
                .enableVoiceControl(true)
                .setStreamingApps(new String[]{"Netflix", "Twitch", "YouTube"})
                .build();
    }
}
