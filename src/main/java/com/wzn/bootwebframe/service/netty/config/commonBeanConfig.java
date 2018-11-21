package com.wzn.bootwebframe.service.netty.config;

import com.wzn.bootwebframe.service.netty.biz.ICommonBs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Configuration
public class commonBeanConfig {

    @Bean("bizMap")
    public Map<String, ICommonBs> bizMap(){
        Map<String, ICommonBs> bizMap=new HashMap<>();
        return bizMap;
    }

}
