package com.wzn.bootwebframe.service.netty.biz;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Service
public class BizRouter {
    @Resource(name="bizMap")
    private Map<String, ICommonBs> bizMap;

    public  ICommonBs route(String version, String functionCode) {
        return bizMap.get(version + '|' + functionCode);
    }


}
