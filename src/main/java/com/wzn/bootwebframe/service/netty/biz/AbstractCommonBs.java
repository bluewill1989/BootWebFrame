package com.wzn.bootwebframe.service.netty.biz;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Slf4j
public abstract class AbstractCommonBs implements ICommonBs {

    @Setter
    protected String version;
    @Setter
    protected String functionCode;

    @Resource(name="bizMap")
    private Map<String, ICommonBs> bizMap;

    @PostConstruct
    protected void registerBs() throws Exception {
        String key = version + '|' + functionCode;
        Assert.isNull(bizMap.get(key), "Version=" + version + ",FunctionCode=" + functionCode + " has been registered.");
        bizMap.put(key, this);
        log.info("成功注册: version={}, function code={}, class={}", version, functionCode, this.getClass().getName());
    }
}
