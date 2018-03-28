package com.reflect;

public class Student extends Person {
    private String name;
    private int age;
    private char sex;
    private String address;

    public Student(String name, int age, char sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    private Student(String name, int age, char sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {

        this.name = name;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
