package Obserable;

import java.util.Iterator;
import java.util.Vector;

/**
 * 早报的抽象方法
 * 方便扩展继承
 */
public class NewSubject implements Subject {
    protected Vector<Observer> observers = new Vector<>();//用于存放订阅者

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer obs = iterator.next();
            if (observer == obs) {
                iterator.remove();
            }
        }
    }

    @Override
    public void notifyMessage(Object o) {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(o);
        }
    }

    @Override
    public void notifyMessage() {
        notifyMessage(null);
    }
}
