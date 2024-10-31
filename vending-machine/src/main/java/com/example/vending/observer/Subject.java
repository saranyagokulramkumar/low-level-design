package com.example.vending.observer;

public interface Subject {
    void addObserver(DisplayObserver observer);
    void removeObserver(DisplayObserver observer);
    void notifyObservers(String message);
}
