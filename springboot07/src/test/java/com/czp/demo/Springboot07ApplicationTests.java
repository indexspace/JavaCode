package com.czp.demo;

import com.czp.demo.mybatis.entity.MyUser;
import com.czp.demo.utils.MyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot07ApplicationTests {

    @Test
    void contextLoads() {

        // Test successful
        List<MyUser> users = new ArrayList<>();
        users.add(new MyUser(100, "hello", "world"));
        users.add(new MyUser(101, "hello", "world"));
        users.add(new MyUser(102, "hello", "100112"));
        System.out.println("new MyUtils().listToString(users) = \n"
                + new MyUtils().listToString(users));

    }

}
