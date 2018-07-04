package com.enumDemo;

/**
 * 枚举
 * 1、没有赋值的情况下 ordinal（）方法就是他的下标
 * 2、enum 中的参数由构造器来决定。
 * 3、enum 的用法和static final  是相同的，但是看起来比较便捷。安全、只能使用一种数据类型
 * 4、可以定义抽象方法
 * 5、可以实现接口（不算什么特性）
 * 6、switch 的使用
 */
public enum Day {
    MONDAY(1), TUESDAY(2), WEDNSDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(0);
    private int desc;

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    Day(int desc) {
        this.desc = desc;
    }
}

enum Day2 {
    TWO(new String[]{
            "123", "1231", "456", "45", "343"
    }), SECOND(new String[]{
            "fsd", "sdsd", "sds", "sdasd"
    }), THREE(new String[]{
            "12sda", "123sda", "weq123"
    });
    private String[] desc;

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    Day2(String[] desc) {

        this.desc = desc;
    }

    public static void print(String[] str) {
        for (String s : str) {
            System.out.println("value:" + s);
        }
    }
}

enum Demo {
    ONE {
        @Override
        public String getInfo() {
            return "one";
        }
    }, TWO {
        @Override
        public String getInfo() {
            return "two";
        }
    };

    public abstract String getInfo();//抽象的方法

    public static void main(String[] args) {
        Demo one = Demo.ONE;//可以向上造型
        System.out.println(one.getInfo());
    }
}

enum DemoSwitch {
    GREEN, RED, BLUE;

    public static void printName(DemoSwitch color) {
        switch (color) {
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }

    public static void main(String[] args) {
        printName(DemoSwitch.BLUE);
    }
}