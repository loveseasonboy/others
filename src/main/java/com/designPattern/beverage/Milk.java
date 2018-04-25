package com.designPattern.beverage;

public class Milk implements Beverage {
    private final static int cost = 5;
    private Menu menu;

    public Milk(Menu menu) {
        this.menu = menu;
    }


    @Override
    public int cost() {
        return menu.cost() + cost;
    }
}
