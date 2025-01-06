package com.smart.home.adapter;

import com.smart.home.factory.Device;
import org.junit.jupiter.api.Test;

public class AdapterPatternTest {
    HomeSpeaker thirdPartySpeaker = new HomeSpeaker();
    Device adaptedSpeaker = new HomeSpeakerAdapter(thirdPartySpeaker);

    SmartLamp smartLamp = new SmartLamp();
    Device adaptedSmartLamp = new SmartLampAdapter(smartLamp);

    @Test
    public void testAdapterPattern(){
        adaptedSpeaker.turnOn();
        adaptedSpeaker.turnOff();

        adaptedSmartLamp.turnOn();
        adaptedSmartLamp.turnOff();
    }
}
