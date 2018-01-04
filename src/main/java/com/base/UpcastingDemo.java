package com.base;

public class UpcastingDemo {
}

/**
 * 前期绑定 动态绑定
 * final 关闭动态绑定
 * 编译器剧可以为final方法调用生成效率更高的代码
 */
class Note2 {
    private int value;

    private Note2(int val) {
        value = val;
    }

    public static final Note2 middleC = new Note2(0),
            cSharp = new Note2(1),
            cFlat = new Note2(2);
}

class Instrument2 {
    public void play(Note2 n) {
        System.out.println("Instrument2.play(" + n + ")");
    }
}

class Wind2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Wind2.play(" + n + ")");
    }
}

class Stringed2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Stringed2.play(" + n + ")");
    }
}

class Brass2 extends Instrument2 {
    public void play(Note2 n) {
        System.out.println("Brass2.play(" + n + ")");
    }
}

class Music2 {
    public static void tune(Wind2 i) {
        i.play(Note2.middleC);
    }

    public static void tune(Stringed2 i) {
        i.play(Note2.middleC);
    }

    public static void tune(Brass2 i) {
        i.play(Note2.middleC);
    }

    public static void main(String[] args) {
        Wind2 flute = new Wind2();
        Stringed2 violin = new Stringed2();
        Brass2 frenchHorn = new Brass2();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}