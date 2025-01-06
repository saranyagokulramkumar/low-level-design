package com.smart.home.bridge;

public class SystemAlert extends Alert{

    public SystemAlert(CommunicationChannel channel){
        super(channel);
    }
    @Override
    public void sendMessage(String message) {
        System.out.println("System Alert:");
        channel.sendMessage(message);
    }
}
