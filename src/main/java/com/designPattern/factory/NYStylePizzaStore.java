package com.designPattern.factory;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
            case "pepperoni":
                pizza = new NYStylePepperoniPizza();
                break;
            case "clam":
                pizza = new NYStryleClamPizza();
                break;
            case "veggie":
                pizza = new NYStryleVeggiePizza();
                break;
        }
        return pizza;
    }
}
