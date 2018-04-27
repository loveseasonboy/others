package com.designPattern.singleton;

public class Test {
    public static void main(String[] args) {
        //Singleton singleton =new Singleton();
        //SingletonHurry singletonHurry =new SingletonHurry();
        Singleton singleton =Singleton.getSingletonInstance();
        SingletonHurry singletonHurry =SingletonHurry.getInstance();
    }
}
