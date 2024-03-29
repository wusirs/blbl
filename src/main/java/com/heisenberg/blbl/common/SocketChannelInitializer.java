package com.heisenberg.blbl.common;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-03-28 16:27:27
 */

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * @author visy.wang
 * @description: Socket通道初始化器
 * @date 2022/12/14 14:37
 */
public class SocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //添加对byte数组的编解码，是由netty提供的
        pipeline.addLast(new ByteArrayDecoder()); //入站
        pipeline.addLast(new ByteArrayEncoder()); //出站
        //添加自己的入站处理器
        pipeline.addLast(new SocketInboundHandler());
    }
}

