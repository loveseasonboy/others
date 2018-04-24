package com.designPattern.sbjectAndObserver;

/**
 * 策略模式：定义算法簇，分别封装起来，让他们之间相互替换，此模式让算法的变化独立于使用算法的客户
 * 观察着模式：在对象之间定义一对多的依赖，当一个对象改变状态，依赖它的对象都会收到通知，并自动更新
 *  一、优点 1、一对多的对象更新2、依赖的解耦、易于维护3、方便添加添加观察着
 *
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay current = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);


    }
}
