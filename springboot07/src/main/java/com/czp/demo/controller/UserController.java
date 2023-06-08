package com.czp.demo.controller;

import com.czp.demo.mapper.MyUserMapper;
import com.czp.demo.mybatis.entity.MyUser;
import com.czp.demo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserMapper myUserMapper;

    @RequestMapping("/all")
    public String userQueryAll(){
        List<MyUser> myUsers = myUserMapper.queryAll();
        String result = new MyUtils().listToString(myUsers);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/select/{id}")
    public String userQueryById(@PathVariable("id") int id){
        return myUserMapper.queryById(id).toString();
    }

    @RequestMapping("/insert")
    public String userInsert(MyUser myUser){
        myUserMapper.addUser(myUser);
        return userQueryAll() + "\n" + myUser.toString();
    }

    @RequestMapping("/delete/{id}")
    public String userDelete(@PathVariable("id") int id){
        myUserMapper.deleteUser(id);
        return userQueryAll();
    }

    @RequestMapping("update/{id}/{uname}/{pwd}")
    public String userUpdate(@PathVariable("id") int id,
                             @PathVariable("uname") String uname,
                             @PathVariable("pwd") String pwd){
        MyUser myUser = new MyUser();
        myUser.setId(id);
        myUser.setUname(uname);
        myUser.setPwd(pwd);
        myUserMapper.updateUser(myUser);
        return userQueryAll();
    }

}
