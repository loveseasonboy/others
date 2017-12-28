package com.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * NIO --第三版本的写法
 */
public class HelloWorldServer {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                /**
                 * 改造传递pojo类
                 */
                return Channels.pipeline(new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())), new ObjectServerHandler());
                //return Channels.pipeline(new HelloServerHandler());
            }
        });
        bootstrap.bind(new InetSocketAddress(9000));
    }

    private static class HelloServerHandler extends SimpleChannelHandler {
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
            System.out.println("hello world,i'm server");
        }
    }

    public static class ObjectServerHandler extends SimpleChannelHandler {
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            Command command = (Command) e.getMessage();
            System.out.println(command.getActionName());
        }
    }
}
