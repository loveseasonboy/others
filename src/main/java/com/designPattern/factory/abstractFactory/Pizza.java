package com.designPattern.factory.abstractFactory;

import com.designPattern.factory.ingredient.*;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("bake...");
    }

    void cut() {
        System.out.println("cut...");
    }

    void box() {
        System.out.println("box...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
