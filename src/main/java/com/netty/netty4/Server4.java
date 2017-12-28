package com.netty.netty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 第4版的写法
 */
public class Server4 {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();//这个事件绑定socket端口
        EventLoopGroup workerGroup = new NioEventLoopGroup();//这个是个channel通道
        bootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(9000)
                .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new EchoServerHandler());
            }
        });
        try {
            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(Server4.class.getName() + " started and listen on " + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                bossGroup.shutdownGracefully().sync();
                workerGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
