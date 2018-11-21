package com.wzn.bootwebframe.service.netty.biz;

import com.wzn.bootwebframe.service.netty.ClientMessage;
import com.wzn.bootwebframe.service.netty.biz.filter.ICommonFilter;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
public abstract class AbstractCommonFilterBs extends AbstractCommonBs {
    @Getter
    @Setter
    private ICommonFilter filter;
    @Override
    public void preHandle(ClientMessage msg){
        if (filter != null) {
            filter.doFilter(msg);
        }
    }
}
