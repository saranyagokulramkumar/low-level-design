package com.smart.home.bridge;

public class EmailChannel implements CommunicationChannel{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: "+message);
    }
}
