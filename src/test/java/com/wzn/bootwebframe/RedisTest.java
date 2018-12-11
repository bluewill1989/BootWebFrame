package com.wzn.bootwebframe;

import com.wzn.bootwebframe.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DESCRIPTION:
 * redis测试类
 *
 * @author will
 * @create 2018-11-22 10:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    RedisService redisService;

    @Test
    public void getTest(){
        String value = redisService.getEntity("1111");
        log.info("value={}", value);

        String value2 = redisService.getEntity("2222");
        log.info("value2={}", value2);
    }

}