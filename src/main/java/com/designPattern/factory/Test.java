package com.designPattern.factory;

/**
 * 工厂方法模式：
 *      定义了一个创建对象的接口（interface和abstract），但由子类决定要实例化的类
 *      是那一个，工厂方法让类把实例化推迟到子类
 * 依赖倒置原则：
 *      要依赖抽象，不要依赖具体类
 *
 * 抽象工厂（产品关联起来）和工厂方法（对于创建对象不确定）
 *      1、工厂方法用的方法是继承，抽象工厂是对象的组合
 *      2、抽象工厂可以把相关产品集合起来，工厂方式用来创建对象，由子类决定对象具体类型
 *      3、如果新加入一个产品，那么修改的子类和父类的接口的内容比较繁重。
 */
public class Test {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore =new NYStylePizzaStore();
        nyPizzaStore.orderPizza("clam");
    }
}
