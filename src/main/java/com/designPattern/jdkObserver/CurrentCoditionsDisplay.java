package com.designPattern.jdkObserver;

import java.util.Observable;
import java.util.Observer;

public class CurrentCoditionsDisplay implements Observer {
    public CurrentCoditionsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("更新操作正在进行。。。");
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            System.out.println("数据获取：" + weatherData.getHumidity());
        }
        System.out.println("传输其他的数据:" + arg);
    }
}
