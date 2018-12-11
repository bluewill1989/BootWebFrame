package com.wzn.bootwebframe.service.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION:
 *
 * @author will
 * @create 2018-11-09 15:47
 */
@Slf4j
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void addEntity(String id, String request){
        log.info("保存时的id：{}", id);
        redisTemplate.opsForValue().set(id, request);
    }

    @Override
    public String getEntity(String id){
        return redisTemplate.opsForValue().get(id);
    }
}