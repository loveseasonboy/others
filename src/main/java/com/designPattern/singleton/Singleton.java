package com.designPattern.singleton;

/**
 * 饱汉式的编程
 * 单列模式 ：双重检测 volatile 和synchronized
 */
public class Singleton {
    /**
     * 防止使用new
     */
    private Singleton() {
    }

    private volatile static Singleton singleton;

    public static Singleton getSingletonInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
