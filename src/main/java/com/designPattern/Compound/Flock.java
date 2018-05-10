package com.designPattern.Compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合模式
 */
public class Flock implements Quackable {
    private List<Quackable> quackers = new ArrayList();
    public void add(Quackable quackable) {
        quackers.add(quackable);
    }

    @Override
    public void quack() {
        /**
         * 迭代模式
         */
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quackable = iterator.next();
            quackable.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        /**
         * 每个鸭子都注册一个自己的观察者来观察自己
         */
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quackable = iterator.next();
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
    }
}
