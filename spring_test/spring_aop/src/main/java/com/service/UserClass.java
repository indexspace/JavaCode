package com.service;

import org.springframework.stereotype.Component;


public class UserClass implements User {

    @Override
    public int addUser() {
        System.out.println("增加了一个用户");
        return 1;
    }

    @Override
    public int deleteUser() {
        System.out.println("删除了一个用户");
        return 2;
    }
}
