package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO流操作--server端
 * 难点：服务多事件的注册。
 * 和io流处理方式相似，都是使用套接字来链接，不同的是NIO操作的是缓存，
 * 而不是io流。
 * 服务器事件的注册最开始的时候必须是SelectionKey.OP_ACCEPT
 * 客户端事件的注册最开始的时候必须是SelectionKey.OP_CONNECT
 */
public class NIOServer {
    private static final int BUF_SIZE = 1024;
    private ByteBuffer sendBuffer = ByteBuffer.allocate(BUF_SIZE);
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(BUF_SIZE);
    private Selector selector;
    private static final int PORT = 9000;
    private int timeOut = 3000;

    public static void main(String[] args) {
        try {
            new NIOServer(NIOServer.PORT).listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public NIOServer(int port) throws IOException {
        //1.开启套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //3.获取套接字服务
        ServerSocket serverSocket = serverSocketChannel.socket();
        //4.设置套接字监听端口
        serverSocket.bind(new InetSocketAddress(PORT));
        //5.打开Selector
        selector = Selector.open();
        //6.注册通道的类型及其Selector
        //注意：这个地方的注册类必须是SelectionKey.OP_ACCEPT，这是服务的起始
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("---------服务已经启动了-------");
        System.out.println("---------监听端口为：" + PORT + "------");
    }

    private void listen() throws IOException {
        while (true) {
            //详解selector.select()方法，这个方法没有接入的时候是0
            if (selector.select(timeOut) == 0) {
                System.out.println("---暂无信息接入---");
                continue;
            }
            //解析各种类型通道数据
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                handleKey(selectionKey);
                //删除该条类型数据，通道是不会主动删除的
                iterator.remove();
            }
        }
    }

    //处理类型数据
    private void handleKey(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketServer = null;
        String receiveText;
        String sendText;
        //启动的服务的套接字的准备工作
        if (key.isAcceptable()) {
            serverSocketChannel = (ServerSocketChannel) key.channel();
            socketServer = serverSocketChannel.accept();
            socketServer.configureBlocking(false);
            socketServer.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            socketServer = (SocketChannel) key.channel();
            receiveBuffer.clear();
            int count = 0;
            count = socketServer.read(receiveBuffer);
            if (count > 0) {
                receiveText = new String(receiveBuffer.array(), 0, count);
                System.err.println("服务器接受客户端数据：" + receiveText);
                //注册writer数据事件
                socketServer.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (key.isWritable()) {
            sendBuffer.clear();
            socketServer = (SocketChannel) key.channel();
            sendText = "----hello I am Server----";
            sendBuffer.put(sendText.getBytes());
            sendBuffer.flip();
            socketServer.write(sendBuffer);
            System.err.println("服务端发送一条数据+" + sendText);
            socketServer.register(selector,SelectionKey.OP_READ);
        }
    }
}
