package com.designPattern.beverageOther;

public class Test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.description + ":" + beverage.cost());

        Mocha beverage1 = new Mocha(new Espresso());
        System.out.println(beverage1.description + ":" + beverage1.cost());
    }
}
