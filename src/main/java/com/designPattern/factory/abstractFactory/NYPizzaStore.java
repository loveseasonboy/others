package com.designPattern.factory.abstractFactory;

import com.designPattern.factory.NYStryleClamPizza;
import com.designPattern.factory.NYStryleVeggiePizza;
import com.designPattern.factory.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected com.designPattern.factory.Pizza createPizza(String type) {
        com.designPattern.factory.Pizza pizza = null;
        switch (type) {
            case "veggie":
                pizza = new NYStryleVeggiePizza();
                break;
            case "clam":
                pizza = new NYStryleClamPizza();
                break;
        }
        return null;
    }
}
