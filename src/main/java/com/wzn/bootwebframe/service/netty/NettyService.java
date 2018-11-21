package com.wzn.bootwebframe.service.netty;


import com.wzn.bootwebframe.service.netty.biz.BizRouter;
import com.wzn.bootwebframe.service.netty.handler.NettyHttpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Created by Administrator on 2017/11/16.
 */
@Slf4j
@Component
public class NettyService {

    @Value("${netty.server.port}")
    private Integer port;
    @Autowired
    private BizRouter bizRouter;

    EventLoopGroup bossGroup = null;
    EventLoopGroup workerGroup = null;

    @PostConstruct
    public void init() {
        try {
            bossGroup = new NioEventLoopGroup(1);
            workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true);
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                                      protected void initChannel(SocketChannel channel) throws Exception {
                                          channel.pipeline().addLast(new HttpResponseEncoder());
                                          channel.pipeline().addLast(new HttpRequestDecoder());
                                          channel.pipeline().addLast(new HttpObjectAggregator(65535));
                                          channel.pipeline().addLast(new NettyHttpServerHandler(bizRouter));

                                      }
                                  }

                    );
            ChannelFuture future = b.bind(port).sync();
            if (future.isSuccess()) {
                log.info("Server bound port:{}", port);
            } else {
                log.info("Server bound fail:{}", future.cause());
            }
        } catch (InterruptedException e) {
            log.error("start error", e.getCause());
        }
    }

    @PreDestroy
    private void destory() {
        log.info("destroy server resources");
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        bossGroup = null;
        workerGroup = null;
    }


}


