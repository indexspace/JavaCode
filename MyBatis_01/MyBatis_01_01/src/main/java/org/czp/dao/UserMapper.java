package org.czp.dao;

import org.apache.ibatis.annotations.*;
import org.czp.pojo.MyUser;

public interface UserMapper {
    // 增
    @Insert("insert into MyUser(id,uname,pwd) values (#{id},#{uname},#{pwd})")
    void addUser(@Param("id") int id, @Param("uname") String uname, @Param("pwd") String pwd);
    // 删
    @Delete("delete from MyUser where id = #{ID}")
    void deleteUserById(@Param("ID") int id);
    // 查
    @Select("select * from Mybatis.MyUser where id = #{ID}")
    MyUser selectUserById(@Param("ID") int id);
    // 改
    @Update("update MyUser set pwd = #{pwd} where id = #{ID}")
    void updatePassword(@Param("ID") int id, @Param("pwd") String pwd);
}