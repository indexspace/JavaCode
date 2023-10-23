package com.example.dataredisdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class IdUtils {

    private StringRedisTemplate redisTemplate;
    private final Long COUNT_BIT = 32L;

    public IdUtils(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long generateId(String prefix) {
        LocalDateTime now = LocalDateTime.now();
        long second = now.toEpochSecond(ZoneOffset.UTC);

        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        Long id = redisTemplate.opsForValue().increment("inc:" + prefix + ":" + date);

        return second << COUNT_BIT | id;
    }
}
