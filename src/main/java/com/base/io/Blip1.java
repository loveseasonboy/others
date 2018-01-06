package com.base.io;

import java.io.*;

/**
 * 序列化的控制
 * 实现Externalizable的接口
 * 在序列化的时候会调用其实现的方法
 * 在反序列化的时候会调用这两个方法来初始化构造器
 */
public class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

class Blips {
    public static void main(String[] args) {
        System.out.println("Constructor objects:");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        try {
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Blips.out"));
            o.writeObject(blip1);
            o.writeObject(blip2);
            o.close();
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("Blips.out"));
            blip1= (Blip1) in.readObject();
            //throws exception
            //构造器必须是public的修饰符
            blip2= (Blip2) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}