package com.example.dataredisdemo;

import com.example.dataredisdemo.utils.RedisLock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class LockTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testLock() {
        RedisLock lock = new RedisLock(stringRedisTemplate, "czpLockName");
        for (int i = 0; i <100; i++) {
            new Thread(() -> {
                // 获取锁
                if (!lock.tryLock(50L)) {
                    System.out.println("获取锁失败");
                }
                else {
                    System.out.println("获取锁成功");
                    lock.unlock();
                }
            }).start();
        }
    }
}
