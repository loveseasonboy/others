package com.designPattern.command;

/**
 * 遥控器的7个控制按钮
 */
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n -------Remote Control-------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("[slot:" + i + "]" + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuilder.toString();
    }
}
