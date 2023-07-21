package com.example.dataredisdemo;

import com.example.dataredisdemo.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class DataRedisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // json工具
    public static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testValue() throws JsonProcessingException {

        // 创建对象  转成json串  存入Redis
        User iUser = new User("虎哥",18);
        String iJson = mapper.writeValueAsString(iUser);
        stringRedisTemplate.opsForValue().set("user:1", iJson);

        // 从Redis取出json  json转成Java对象  打印输出
        String oJson = stringRedisTemplate.opsForValue().get("user:1");
        User oUser = mapper.readValue(oJson, User.class);
        System.out.println("oUser = " + oUser);
    }

}
