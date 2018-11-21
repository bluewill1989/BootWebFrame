package com.wzn.bootwebframe.service.netty.biz.filter;

import com.wzn.bootwebframe.service.netty.ClientMessage;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
public interface ICommonFilter {
    void doFilter(ClientMessage msg);
}
