package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 详细的用法已经在在此案例中
 * 客户端（NIO流）
 * 难点就是：这个多事件的注册
 */
public class NIOClient {
    private static final int BUF_SIZE = 1024;
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(BUF_SIZE);
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(BUF_SIZE);
    private static final String IP_ADRESS = "127.0.0.1";
    private static final int PROT = 9000;

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            //此处的的SelectionKey.OP_CONNECT 必须是这个，不能是别的。
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            //设置链接ip,端口号
            socketChannel.connect(new InetSocketAddress(IP_ADRESS, PROT));
            while (true) {
                if (selector.select(1000) == 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isConnectable()) {
                            SocketChannel client = (SocketChannel) key.channel();
                            //判断链接是否在可以操作
                            if (client.isConnectionPending()) {
                                client.finishConnect();//链接
                                System.err.println("完成链接");
                                sendBuffer.clear();
                                sendBuffer.put("hello,server".getBytes());
                                sendBuffer.flip();
                                client.write(sendBuffer);
                                client.register(selector, SelectionKey.OP_READ);
                            }
                        } else if (key.isReadable()) {
                            SocketChannel client = (SocketChannel) key.channel();
                            receiveBuffer.clear();
                            int count = 0;
                            count = client.read(receiveBuffer);
                            if (count > 0) {
                                String receiveTest =new String(receiveBuffer.array(),0,count);
                                System.err.println("客户端接受服务器端的数据："+receiveTest);
                                client.register(selector,SelectionKey.OP_WRITE);
                            }
                        }else if(key.isWritable()){
                            sendBuffer.clear();
                            SocketChannel client = (SocketChannel) key.channel();
                            String sendText="hello server";
                            sendBuffer.put(sendText.getBytes());
                            sendBuffer.flip();
                            client.write(sendBuffer);
                            System.out.println("客户端发送数据："+sendText);
                            client.register(selector,SelectionKey.OP_READ);
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
