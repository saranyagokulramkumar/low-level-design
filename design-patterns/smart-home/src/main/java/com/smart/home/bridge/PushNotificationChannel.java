package com.smart.home.bridge;

public class PushNotificationChannel implements CommunicationChannel{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Push notification: "+message);
    }
}
