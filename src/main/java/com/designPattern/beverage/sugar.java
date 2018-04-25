package com.designPattern.beverage;

public class sugar implements Beverage {
    private Menu menu;

    public sugar(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int cost() {
        return menu.cost() + 20;
    }
}
