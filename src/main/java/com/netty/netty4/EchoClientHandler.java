package com.netty.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        System.out.println("Client received:"+byteBuf.toString(CharsetUtil.UTF_8));
//        while (byteBuf.isReadable()){
//            System.out.print((char)byteBuf.readByte());
//        }
        //ByteBuf bf=Unpooled.buffer();
        //bf.writeBytes(("你好啊！我是客户端").getBytes());
        String str ="你好啊！我是客户端";
        ctx.writeAndFlush(Unpooled.copiedBuffer(str,CharsetUtil.UTF_8))
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //ctx.write("Netty rocks!");
        ctx.write(Unpooled.copiedBuffer("你好啊：Netty rocks!", CharsetUtil.UTF_8));
        ctx.flush();
        System.out.println("Netty rocks!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
