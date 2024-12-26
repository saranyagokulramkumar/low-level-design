package com.smart.home.builder;

import com.smart.home.factory.Device;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {
    SmartTV tv = new SmartTV.Builder()
            .setScreenSize("55 inches")
            .setResolution("4K")
            .enableVoiceControl(true)
            .setStreamingApps(new String[]{"Netflix","Amazon", "Youtube"})
            .build();

    @Test
    public void testBuilderPattern(){
        tv.turnOn();
        tv.turnOff();

        System.out.println("SmartTV Configuration:");
        System.out.println("Screen size: "+tv.getScreenSize());
        System.out.println("Resolution: "+tv.getResolution());
        System.out.println("Voice Control Enabled: "+tv.isVoiceControlEnabled());
        System.out.println("Streaming Apps: "+String.join(", ", tv.getStreamingApps()));
    }

    @Test
    public void testBuilderPatternWithDirectory(){
        SmartTVDirector smartTVDirector = new StandardTVDirector();
        SmartTV standardTV = smartTVDirector.createSmartTV();
        standardTV.turnOn();
        System.out.println("Standard TV Resolution: " + standardTV.getResolution());
        standardTV.turnOff();

        System.out.println();

        SmartTVDirector highEndTVDirector = new HighEndSmartTVDirector();
        SmartTV highEndTV = highEndTVDirector.createSmartTV();
        highEndTV.turnOn();
        System.out.println("High-End TV Apps: " + String.join(", ", highEndTV.getStreamingApps()));
        highEndTV.turnOff();

        System.out.println();

        SmartTVDirector gamingTVDirector = new GamingTVDirector();
        SmartTV gamingTV = gamingTVDirector.createSmartTV();
        gamingTV.turnOn();
        System.out.println("Gaming TV Screen Size: " + gamingTV.getScreenSize());
        gamingTV.turnOff();
    }
}
