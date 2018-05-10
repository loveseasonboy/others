package com.designPattern.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程调用 -服务端
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says,'Hey'";
    }

    public static void main(String[] args) {
        try {
            MyRemote myRemote = new MyRemoteImpl();
            LocateRegistry.createRegistry(8080);//注册监听端口
            Naming.bind("rmi://localhost:8080/RemoteHello", myRemote);//绑定传输类
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
