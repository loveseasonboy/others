package com.designPattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式-clone
 * 浅度clone，克隆的是引用
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("hello");
        person1.setAge(30);
        person1.setSex("男");
//
//        Person person2 = new Person();
//        person2.setName("world");
//        person2.setAge(30);
//        person2.setSex("男");
//
//        Person person3 = person1.clone();
//        person3.setName("你好！");
//        System.out.println(person1.getName());
//        System.out.println(person3.getName());

        List<String> friends =new ArrayList<>();
        friends.add("1");
        friends.add("2");

        person1.setFriends(friends);
        Person person4 =person1.clone();
        System.out.println(person1.getFriends());
        System.out.println(person4.getFriends());

        friends.add("3");
        person1.setFriends(friends);
        System.out.println(person1.getFriends());
        System.out.println(person4.getFriends());
    }
}
