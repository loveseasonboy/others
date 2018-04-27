package com.designPattern.singleton;

/**
 *  性能的下降
 * 饿汉式单列:
 *      在初始化的时候就已经保障了线程的安全，
 *      使用静态的
 */
public class SingletonHurry {
    private static SingletonHurry singletonHurry = new SingletonHurry();

    /**
     * 私有的构造器
     */
    private SingletonHurry() {

    }

    public static SingletonHurry getInstance() {
        return singletonHurry;
    }
}
