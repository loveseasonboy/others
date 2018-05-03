package com.designPattern.state;

public class SoldState extends State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.count > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops,Out gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
