package com.designPattern.factory.simpleFactory;

/**
 * 简单的工厂：只是一种编码习惯
 */
public class Test {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);
        pizzaStore.orderPizza("clam");
    }
}
