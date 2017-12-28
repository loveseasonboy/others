package com.netty.netty4;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
    public static void main(String[] args) {
        //线程池
        EventLoopGroup group = new NioEventLoopGroup();
        //引导的启动客户端
        Bootstrap bootstrap =new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress("127.0.0.1",9000))
                .handler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new EchoClientHandler());
            }
        });
        try {
            ChannelFuture future=bootstrap.connect().sync();
            //future.channel().writeAndFlush("hello Netty");
            //System.out.println("客户端发送数据："+"hello Netty");
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()){
                        System.out.println("client connected");
                    }else {
                        System.out.println("client attemp failed");
                        channelFuture.cause().printStackTrace();
                    }
                }
            });
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
