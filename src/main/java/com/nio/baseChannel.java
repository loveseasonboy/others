package com.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio 中的channel的读取数据到缓存中去
 * 可以双向的操作
 */
public class baseChannel {
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("D:\\javaTools\\iedaWorkSpaces\\study\\others\\src\\main\\resources\\config/db.properties", "rw");
            //放入管道中
            FileChannel inChannel = accessFile.getChannel();
            //和io的缓存的声明是一样的，声明一个1024byte的缓存
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //读取到缓存中
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("READ" + bytesRead);
                buf.flip();//设置读取的位置(切换读取的位置)
                while (buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                //buf.clear();//清除缓存
                buf.compact();//清除已经读取的数据
                bytesRead = inChannel.read(buf);//如果没有读取完就继续读取
            }
            accessFile.close();//关闭读取的io流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
