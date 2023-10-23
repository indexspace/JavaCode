package com.example.dataredisdemo.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisLock {
    private StringRedisTemplate redisTemplate;
    private String name;
    private final static String PREFIX = "LOCK:";
    private final static String ID_PREFIX = UUID.randomUUID().toString() + "-";

    // 传入锁的名称、StringRedisTemplate对象来构造锁
    public RedisLock(StringRedisTemplate redisTemplate, String name) {
        this.redisTemplate = redisTemplate;
        this.name = name;
    }

    // 获取锁, return成功与否
    public boolean tryLock(Long timeoutSec) {
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(PREFIX + name, threadId, timeoutSec, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(ifAbsent);
    }

    // 释放锁
    public void unlock(){
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        String id = redisTemplate.opsForValue().get(PREFIX + name);
        if(threadId.equals(id)) {
            redisTemplate.delete(PREFIX + name);
        }
    }
}
