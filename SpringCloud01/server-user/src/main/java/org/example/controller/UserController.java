package org.example.controller;

import org.example.entities.MyUser;
import org.example.mapper.UserMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/queryAll")
    public List<MyUser> queryAll(){
        return userMapper.queryAllUsers();
    }

    @RequestMapping("/queryById/{id}")
    public MyUser queryById(@PathVariable("id") int id){
        return userMapper.queryUserById(id);
    }

    @RequestMapping("/queryByUname/{uname}")
    public MyUser queryByUname(@PathVariable("uname") String uname){
        return userMapper.queryUserByUname(uname);
    }

}
