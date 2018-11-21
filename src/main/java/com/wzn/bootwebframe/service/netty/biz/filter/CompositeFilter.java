package com.wzn.bootwebframe.service.netty.biz.filter;

import com.wzn.bootwebframe.service.netty.ClientMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
public class CompositeFilter implements ICommonFilter {

    @Setter
    @Getter
    private List<ICommonFilter> filters;

    public CompositeFilter(List<ICommonFilter> filters) {
        super();
        this.filters = filters;
    }

    public CompositeFilter() {
        super();
    }
    @Override
    public void doFilter(ClientMessage msg) {
        for (ICommonFilter filter : filters) {
            filter.doFilter(msg);
        }
    }
}
