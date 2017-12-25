package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServerNIO {
    private static final int BUF_SIZE = 1024;
    private static final int PORT = 9000;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        selector();
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);//取消阻塞
            int interestSet = SelectionKey.OP_ACCEPT & SelectionKey.OP_CONNECT;

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册那中类型
            //serverSocketChannel.register(selector,);//连接事件
            //serverSocketChannel.register(selector,SelectionKey.OP_WRITE);//写事件
            while (true) {
                if (selector.select(TIMEOUT) == 0) {
                    System.out.println("----------------无注册事件就绪----------------------------");
                    continue;
                }
                System.out.println("------------------已经有注册事件就绪----------------------------");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        System.out.println("---------访问事件-----------");
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                        SocketChannel sc = serverSocketChannel1.accept();
                        sc.configureBlocking(false);
                        sc.register(key.selector(), SelectionKey.OP_READ|SelectionKey.OP_WRITE|SelectionKey.OP_CONNECT, ByteBuffer.allocate(BUF_SIZE));
                    }
                    if (key.isReadable()) {
                        System.out.println("-----------读取事件----------------");
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        long bytesRead = sc.read(buf);
                        while (bytesRead > 0) {
                            buf.flip();
                            while (buf.hasRemaining()) {
                                System.out.print((char) buf.get());
                            }
                            System.out.println("");
                            buf.clear();
                            bytesRead = sc.read(buf);
                        }
                        if (bytesRead == -1) {
                            sc.close();
                        }
                    }
                    if (key.isValid() && key.isWritable()) {
                        System.out.println("---------写入事件---------------");
                        String str ="hello! client.....";
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        buf.put(str.getBytes());
                        buf.flip();
                        SocketChannel sc = (SocketChannel) key.channel();
                        while (buf.hasRemaining()) {
                            sc.write(buf);
                        }
                        buf.compact();
                    }
                    if (key.isConnectable()) {
                        System.out.println("isConnectable=true");
                    }
                    iterator.remove();//删除通道中的数据
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
