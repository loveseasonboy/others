package com.designPattern.state;

public class SoldOutState extends State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    void insertQuarter() {
        System.out.println("没有糖果了");
        gumballMachine.setState(gumballMachine.getSoldOutState());
    }

}
