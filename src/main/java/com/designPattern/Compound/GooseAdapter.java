package com.designPattern.Compound;

/**
 * 适配器-把鹅的叫声适配在鸭子的叫声里
 */
public class GooseAdapter implements Quackable {
    private Observable observable;
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        this.observable=new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
