package com.designPattern.Compound;

/**
 * 抽象工厂模式-创建一个家族产品
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();

    public abstract Quackable createReadheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
