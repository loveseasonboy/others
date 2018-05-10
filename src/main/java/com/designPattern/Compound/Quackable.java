package com.designPattern.Compound;

/**
 * 鸭子叫的 动作
 */
public interface Quackable extends QuackObservable{
    void quack();
}
