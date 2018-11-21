package com.wzn.bootwebframe.service.netty.biz;

import com.wzn.bootwebframe.service.netty.ClientMessage;

import java.io.IOException;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
public interface ICommonBs {
     void preHandle(ClientMessage msg);
     void handle(ClientMessage msg);
     void postHandle(ClientMessage msg);
}
