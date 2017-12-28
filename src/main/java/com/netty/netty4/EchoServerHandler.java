package com.netty.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("服务器:" + in.toString(CharsetUtil.UTF_8));
        //in.release();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务器打印:channelReadComplete");
        //ByteBuf byteBuf=Unpooled.buffer();
        //byteBuf.writeBytes(("").getBytes());
        String str = "你好啊！我是服务器";
        ctx.writeAndFlush(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
        //.addListener(ChannelFutureListener.CLOSE);
    }
}
