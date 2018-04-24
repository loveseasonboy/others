package com.designPattern.jdkObserver;

/**
 * jdk内置的观察者模式
 * 主题是继承的
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCoditionsDisplay coditionsDisplay=new CurrentCoditionsDisplay(weatherData);

        weatherData.setChange(90,20.5f,30);
    }
}
