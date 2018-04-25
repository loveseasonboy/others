package com.designPattern.beverageOther;

public class Mocha extends CodimentDecorator {
    private Beverage beverage;

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        setDescription(beverage.getDescription() + ",Mocha");
    }
}
