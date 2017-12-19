package com.autoClassPath;

/**
 * 类加载器的说明
 * Bootstrap 就是一个初始化的时候的引导（原因是Bootstrap Loader（启动类加载器）是用C语言实现的， //找不到一个确定的返回父Loader的方式，于是就返回null）
 * extClassLoader 父级类加载器，只是双亲委派中的父级，子集会先请求父级去验证，解析，加载类，
 * 前提是父类可以找到对应的类。子类再（本地的类加载器）去加载对应的类。
 */
public class ClassLoader {
    public static void main(String[] args) {
        ClassLoader classloader = new ClassLoader();
        Class c =classloader.getClass();
        java.lang.ClassLoader loader =c.getClassLoader();
        System.out.println(loader);//AppClassLoader
        System.out.println(loader.getParent());//extClassLoader
        System.out.println(loader.getParent().getParent());//bootstrap

        try {
            //第一种加载类的方式
            Class<?> aClass = Class.forName("");
            //第二种加载类的方式
            Class<?> aClass1= ClassLoader.class;
            //第三种加载类的方式--通过对象的方式来获取（也可以通过反射来获取）
            ClassLoader classloader1 = new ClassLoader();
            Class aClass2=classloader1.getClass();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
