package com.designPattern.Compound;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
