package com.designPattern.sbjectAndObserver;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float humidity;
    private float pressure;
    private Subject subject;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current pressure:" + pressure + " and "
                + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
