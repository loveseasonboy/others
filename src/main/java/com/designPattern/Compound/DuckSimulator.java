package com.designPattern.Compound;

/**
 * 叫声模拟器
 */
public class DuckSimulator {
    /**
     * 使用工厂模式来创建实体类
     *
     * @param duckFactory
     */
    public void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createReadheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        //适配器--鹅的叫声掺杂在鸭子中间
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Duck  Simulator");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(mallardDuck);

        Flock flockMallards = new Flock();

        flockMallards.add(duckFactory.createMallardDuck());
        for (int i = 0; i < 4; i++) {
            flockMallards.add(duckFactory.createMallardDuck());
        }

        System.out.println("Duck Simulator : whole Flock Simulation");
        Quackologist quackologist = new Quackologist();
        //gooseDuck.registerObserver(quackologist);
        flockOfDucks.registerObserver(quackologist);
        simulate(flockOfDucks);

        System.out.println("Duck Simulator : Mallard Flock Simulation");
        simulate(flockMallards);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);//声音掺入鹅的叫声

        //System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }
}
