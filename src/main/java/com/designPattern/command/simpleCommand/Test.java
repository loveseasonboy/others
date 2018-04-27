package com.designPattern.command.simpleCommand;

/**
 * 有点像粉装模式，用于扩展
 */
public class Test {
    public static void main(String[] args) {
        SimpleRemoteControl control=new SimpleRemoteControl();
        control.setCommand(new LightOnCommand(new Light()));
        control.buttonWasPressed();
    }
}
