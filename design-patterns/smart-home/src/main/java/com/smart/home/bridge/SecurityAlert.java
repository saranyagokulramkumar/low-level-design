package com.smart.home.bridge;

public class SecurityAlert extends Alert{

    public SecurityAlert(CommunicationChannel channel){
        super(channel);
    }
    @Override
    public void sendMessage(String message) {
        System.out.println("Security Alert: ");
        channel.sendMessage(message);
    }
}
