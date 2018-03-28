package com.reflect;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectTest {
    public static void main(String[] args) throws Exception {
        //constructor
        Class<? extends Object> clazz = Class.forName("com.reflect.Student");
        Student student = (Student) clazz.newInstance();
        student.setAge(50);
        student.setName("TOM");
        student.setSex('男');
        System.out.println(student.toString());

        System.out.println("-------------------------------");
        //获取带String 的的参数的constructor
        Constructor cs_1 = clazz.getConstructor(String.class);
        Student student_1 = (Student) cs_1.newInstance("jek");
        System.out.println(student_1.toString());

        System.out.println("-------------------------------");
        //获取private 权限的 constructor
        Constructor cs_2 = clazz.getDeclaredConstructor(String.class, int.class);
        cs_2.setAccessible(true);
        Student student_2 = (Student) cs_2.newInstance("hit", 30);
        System.out.println(student_2.toString());

        System.out.println("----------------------------------");
        //包含私有的构造
        Constructor<?>[] cans = clazz.getDeclaredConstructors();
        for (int i = 0; i < cans.length; i++) {
            Class<?>[] clazzs = cans[i].getParameterTypes();
            System.out.println("构造函数[" + i + "]:" + cans[i].toString());
            System.out.print("参数类型[" + i + "]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1) {
                    System.out.print(clazzs[j].getName());
                } else {
                    System.out.print(clazzs[j].getName() + ",");
                }
            }
            System.out.println(")");
        }
        System.out.println("-----------------------------");
        //public修饰才可以
        Student student_4 = (Student) clazz.newInstance();
        Field field = clazz.getField("age");//父类的字段 并且是public的才行
        //field.setAccessible(true);
        field.set(student_4, 30);
        System.out.println("field:" + field);
        System.out.println(student_4.toString());
        Field field1 = clazz.getDeclaredField("age");//获取现在这个类的字段
        field1.setAccessible(true);//强制性的使用,不建议这么做，破坏了原有的对像的结构，不安全
        field1.set(student_4, 20);
        System.out.println("type:" + field1.getGenericType());
        System.out.println("field:" + field1);
        System.out.println(student_4.toString());
        System.out.println("-----------------------------");
        //反射对应的数据
        Method method = clazz.getMethod("setAddress", String.class);
        Student student_3 = (Student) clazz.newInstance();
        method.invoke(student_3, "memory");
        System.out.println(student_3.toString());
        Method[] methods = clazz.getMethods();
        for (Method method_1 : methods) {
            System.out.print("方法：" + method_1.getName());
        }
        System.out.println();
        Class<?> clazzzss = (Class<?>) field1.getGenericType();
        Method method_2 = clazz.getMethod("setHeight", clazzzss);//获取的是父子类的方法
        method_2.invoke(student_3, 50);
        System.out.println(student_3.getHeight());
        Method method_3 = clazz.getDeclaredMethod("setName", String.class);//获取子类的
        method_3.invoke(student_3, "hello world");
        System.out.println(student_3.toString());
    }
}
