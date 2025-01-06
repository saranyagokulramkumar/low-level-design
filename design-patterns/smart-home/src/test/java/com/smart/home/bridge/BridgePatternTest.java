package com.smart.home.bridge;

import org.junit.jupiter.api.Test;

public class BridgePatternTest {
    CommunicationChannel smsChannel = new SMSChannel();
    Alert securityAlert = new SecurityAlert(smsChannel);

    CommunicationChannel emailChannel = new EmailChannel();
    Alert systemAlert = new SystemAlert(emailChannel);

    CommunicationChannel pushNotificationChannel = new PushNotificationChannel();
    Alert pushSecurityAlert = new SecurityAlert(pushNotificationChannel);

    @Test
    public void testBridgePattern(){
        securityAlert.sendMessage("Intruder detected at front door!");
        systemAlert.sendMessage("System maintenance scheduled for midnight.");
        pushSecurityAlert.sendMessage("Fire alarm triggered in the kitchen!");
    }
}
