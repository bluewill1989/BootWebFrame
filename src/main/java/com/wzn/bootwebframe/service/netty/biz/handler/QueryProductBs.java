package com.wzn.bootwebframe.service.netty.biz.handler;//package com.chinaums.bm.biz.handler;


import com.wzn.bootwebframe.service.http.HttpHandler;
import com.wzn.bootwebframe.service.netty.ClientMessage;
import com.wzn.bootwebframe.service.netty.biz.AbstractCommonFilterBs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Slf4j
@Service
public class QueryProductBs extends AbstractCommonFilterBs {

    @Autowired
    HttpHandler httpHandler;

    @Override
    public void handle(ClientMessage msg) {

        log.info(" 到 handler:{}", msg);
        String url = msg.getRequestData().getString("url");
        String res = null;
        try {
            res = httpHandler.httpGet(url);
        } catch (IOException e) {
            log.info("io 错误");
        }
        msg.setResponse(res);

    }

    @Override
    public void postHandle(ClientMessage msg) {

        log.info("request iServiceProcess  QueryProductBs");
    }
}
