package com.designPattern.command;

/**
 * 命令模式：将请求封装成对象，这可以让你使用不同的请求、队列、或者日志
 * 请求来参数化其他对象。命令模式也可以支持撤销操作。
 */
public class Test {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        Stereo stereo = new Stereo();

        LightOffCommand lightOffCommand = new LightOffCommand(light);
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        StereoOnWithCDCommand cdCommand = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand offWithCDCommand = new StereoOffWithCDCommand(stereo);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, cdCommand, offWithCDCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);

        remoteControl.onButtonWasPushed(2);
    }
}
