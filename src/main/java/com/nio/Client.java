package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);//是否阻塞
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));
            if (socketChannel.finishConnect()) {
                int i = 0;
                //while (true) {
                    String info = "I'm" + (i++) + "-th information from client";
                    byteBuffer.clear();
                    byteBuffer.put(info.getBytes());
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        System.out.println(byteBuffer);
                        socketChannel.write(byteBuffer);
                    }
               // }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socketChannel!=null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
