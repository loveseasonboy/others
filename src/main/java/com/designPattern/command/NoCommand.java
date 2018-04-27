package com.designPattern.command;

public class NoCommand implements Command {
    private Light light;

    public NoCommand() {
    }

    public NoCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("什么也不没有调用。。。");
    }
}
