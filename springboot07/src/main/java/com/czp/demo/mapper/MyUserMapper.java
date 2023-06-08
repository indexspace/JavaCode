package com.czp.demo.mapper;

import com.czp.demo.mybatis.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyUserMapper {

    List<MyUser> queryAll();

    MyUser queryById(int id);

    void addUser(MyUser myUser);

    void updateUser(MyUser myuser);

    void deleteUser(int id);

}
