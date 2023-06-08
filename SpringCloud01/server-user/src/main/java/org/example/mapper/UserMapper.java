package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entities.MyUser;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from MyUser")
    public List<MyUser> queryAllUsers();

    @Select("select * from MyUser where id = #{id}")
    public MyUser queryUserById(int id);

    @Select("select * from MyUser where uname = #{uname}")
    public MyUser queryUserByUname(String uname);
}
