package com.designPattern.jdkObserver;

/**
 * jdk内置的观察者模式
 * 主题是继承的的。非接口（单一的继承限制比较多）
 * Observable 中的setChanged() 方法 要求主题类必须继承（可以使用内部类来实现多重继承）
 * 设计模式规则：1、接口编码，非实例编码
 *              2、多用组合，少用继承
 *              3、封装变化的
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCoditionsDisplay coditionsDisplay=new CurrentCoditionsDisplay(weatherData);

        weatherData.setChange(90,20.5f,30);
    }
}
