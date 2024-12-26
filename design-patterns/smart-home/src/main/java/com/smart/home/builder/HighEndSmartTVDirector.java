package com.smart.home.builder;

public class HighEndSmartTVDirector implements SmartTVDirector{
    @Override
    public SmartTV createSmartTV() {
        return new SmartTV.Builder()
                .setScreenSize("65 inches")
                .setResolution("4K")
                .enableVoiceControl(true)
                .setStreamingApps(new String[]{"Netflix", "YouTube", "Amazon Prime", "Hulu"})
                .build();
    }
}
