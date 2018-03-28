package com.enumDemo;

public class EnumTest {
    public static void main(String[] args) {
        Day day = Day.THURSDAY;
        System.out.println(day);
        System.out.println(day.ordinal());
        Day day1 = Day.valueOf("MONDAY");
        System.out.println(day1);
        System.out.println("name: " + day.name() + ",desc:" + day.getDesc());
        //Day2 day2 = Day2.TWO;
        System.out.println("desc:" + Day2.THREE.getDesc());
        Day2.print(Day2.THREE.getDesc());
    }

//    public static void print(String[] str) {
//        for (String s : str) {
//            System.out.println("value:" + s);
//        }
//    }
}
