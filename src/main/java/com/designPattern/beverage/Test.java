package com.designPattern.beverage;

public class Test {
    public static void main(String[] args) {
        Menu menu = new Coffee();
        Beverage beverage = new sugar(new Milk(menu));
        System.out.println("一共多少钱：" + beverage.cost());
    }
}
