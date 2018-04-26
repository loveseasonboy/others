package com.designPattern.factory;

import com.designPattern.factory.ingredient.*;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Veggies createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
