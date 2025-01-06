package com.smart.home.bridge;

public abstract class Alert {
    protected CommunicationChannel channel;

    protected Alert(CommunicationChannel channel){
        this.channel = channel;
    }

    public abstract void sendMessage(String message);
}
