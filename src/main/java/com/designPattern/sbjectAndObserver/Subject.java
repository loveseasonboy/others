package com.designPattern.sbjectAndObserver;

/**
 * 主题
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
