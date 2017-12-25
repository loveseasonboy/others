package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    public static void main(String[] args) {
        ioServer();
    }
    public static void ioServer() {
        ServerSocket serverSocket = null;
        InputStream in = null;
        try {
            serverSocket = new ServerSocket(9000);
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while (true) {
                Socket clnSocket = serverSocket.accept();
                SocketAddress clientAddress = clnSocket.getRemoteSocketAddress();
                System.out.println("Handling client at" + clientAddress);
                in = clnSocket.getInputStream();
                while ((recvMsgSize = in.read(recvBuf)) != -1) {
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
