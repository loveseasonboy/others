package com.designPattern.state;

public class HasQuarterState extends State {
    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    void turnCrank() {
        System.out.println("You returned");
        gumballMachine.setState(gumballMachine.getSoldState());
    }
}
