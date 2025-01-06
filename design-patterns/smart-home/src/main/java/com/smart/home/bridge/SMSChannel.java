package com.smart.home.bridge;

public class SMSChannel implements CommunicationChannel{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: "+message);
    }
}
