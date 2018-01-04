package com.base.controller;

/**
 * 温室控制器---内部类的一个使用
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    private class LightOn extends Event {

        public LightOn(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String description() {
            return "Light is on";
        }
    }

    private class LightOff extends Event {

        public LightOff(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String description() {
            return "Light is off";
        }
    }

    private class WaterOn extends Event {

        public WaterOn(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String description() {
            return "Greenhouse water is on";
        }
    }

    private class WaterOff extends Event {

        public WaterOff(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String description() {
            return "Greenhouse water is off";
        }
    }

    private class ThermostatNight extends Event {

        public ThermostatNight(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String description() {
            return "Thermostat on night setting";
        }
    }

    private class ThermostatDay extends Event {

        public ThermostatDay(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String description() {
            return "Thermostat on day setting";
        }
    }

    private int rings;

    private class Bell extends Event {

        public Bell(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            System.out.println("Bing!");
            if (--rings > 0) {
                addEvent(new Bell(System.currentTimeMillis() + 2000));
            }
        }

        @Override
        public String description() {
            return "Ring bell";
        }
    }

    private class Restart extends Event {

        public Restart(long ectTime) {
            super(ectTime);
        }

        @Override
        public void action() {
            long tm = System.currentTimeMillis();
            rings = 5;
            addEvent(new ThermostatNight(tm));
            addEvent(new LightOn(tm + 1000));
            addEvent(new LightOff(tm + 2000));
            addEvent(new WaterOn(tm + 3000));
            addEvent(new WaterOff(tm + 8000));
            addEvent(new Bell(tm + 9000));
            addEvent(new ThermostatDay(tm + 10000));
            addEvent(new Restart(tm + 20000));
        }

        @Override
        public String description() {
            return "Restarting system";
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        long tm = System.currentTimeMillis();
        gc.addEvent(gc.new Restart(tm));
        gc.run();
    }
}
