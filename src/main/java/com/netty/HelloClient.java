package com.netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HelloClient {
    public static void main(String[] args) {
        ClientBootstrap bootstrap=new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool()));
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                /**
                 * 处理对象的传递
                 */
                //return Channels.pipeline(new helloHandler());
                return Channels.pipeline(new ObjectEncoder(),new helloHandler());
            }
        });
        bootstrap.connect(new InetSocketAddress("127.0.0.1",9000));
    }
    private static class helloHandler extends SimpleChannelHandler{
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            //System.out.println("hello world,I'm client");
            Command command=new Command();
            command.setActionName("hello action......");
            e.getChannel().write(command);
        }
    }
}
