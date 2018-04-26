package com.designPattern.factory;

public abstract class Pizza {
    public void prepare() {
        System.out.println("准备pizza 中。。。");
    }

    public void bake() {
        System.out.println("烘烤pizza中....");
    }

    public void cut() {
        System.out.println("pizza cut ....");
    }

    public void box() {
        System.out.println("pizza box...");
    }
}
