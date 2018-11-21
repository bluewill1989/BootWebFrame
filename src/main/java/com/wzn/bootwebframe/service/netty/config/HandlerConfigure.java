package com.wzn.bootwebframe.service.netty.config;

import com.wzn.bootwebframe.service.netty.biz.handler.QueryProductBs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Configuration
public class HandlerConfigure {

    @Bean
    public QueryProductBs queryProductBs(){
        QueryProductBs queryProductBs=new QueryProductBs();
        queryProductBs.setVersion("1.0");
        queryProductBs.setFunctionCode("000001");
        return queryProductBs;
    }
}
