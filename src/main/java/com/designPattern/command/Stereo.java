package com.designPattern.command;

public class Stereo {
    public void on() {
        System.out.println("音响开启。。。");
    }

    public void setCD() {
        System.out.println("CD start...");
    }

    public void setVolume() {
        System.out.println("set volume...");
    }
    public void off(){
        System.out.println("影响关闭。。。");
    }
}
