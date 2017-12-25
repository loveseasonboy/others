package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class newServerNIO {
    private static final int BUF_SIZE = 1024;
    private static final int PROT = 9000;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        server();
    }

    public static void server() {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(PROT));
            int interestSet = SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_READ;
            //serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    System.out.println("----非阻塞式的-----");
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
