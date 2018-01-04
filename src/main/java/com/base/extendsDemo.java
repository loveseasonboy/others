package com.base;

/**
 * 继承的特性
 * 1.可以向上造型，但是重载的部分创建的是谁就用谁的
 * 2.子类完全可以继承父类的一切，包括重写父类的方法。
 * 3.子类可以有自己的属性方法，父类不能使用。
 * 4.调用子类的默认构造器也会调用父类的构造器(默认为无惨构造器)
 */

/**
 * 合成还是继承
 * 合成就是包含关系（private 来合成）
 * 继承就是属于关系
 * 继承的选择：1，判断是否要回到基类（upcasting）
 */
public class extendsDemo {
}

class Cleanser {
    /**
     * 这个地方就是合成
     */
    private String s = new String("Cleanser.");
    Cleanser(){
        System.out.println("Cleanser constructor");
    }
    Cleanser(String a){
        System.out.println("Cleanser constructor one param");
    }
    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute().");
    }

    public void apply() {
        append("apply().");
    }

    public void scrub() {
        append("scrub()");
    }

    public void print() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
    }
}

class Detergent extends Cleanser {
    Detergent(){
        System.out.println("Detergent constructor");
    }
    Detergent(String a){
        System.out.println("Detergent constructor param one");
    }
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append("foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent("q");
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.print();
//        System.out.println("Testing base class:");
//        Cleanser.main(args);
//        Cleanser s = new Detergent();
//        s.scrub();
//        s.print();

    }
}