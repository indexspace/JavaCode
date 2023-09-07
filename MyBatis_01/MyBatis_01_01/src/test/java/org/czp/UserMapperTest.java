package org.czp;

import com.mysql.cj.jdbc.BlobFromLocator;
import org.apache.ibatis.session.SqlSession;
import org.czp.dao.UserMapper;
import org.czp.pojo.MyUser;
import org.czp.utils.MybatisUtils;
import org.junit.*;


public class UserMapperTest {

    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init(){
        // 获取工具类对象sqlSession
        sqlSession = MybatisUtils.getSession();

        // 获取含有selectUser()方法的接口UserMapper
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void close(){
        // ===== !!! 提交事务, 保存增删改的数据至数据库  =====
        // sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }
    // 增
    @Ignore
    @Test
    public void addUserTest(){
        mapper.addUser(2, "lisi", "000004");
    }
    // 删
    @Test
    public void deleteUserByIdTest(){
        mapper.deleteUserById(5);
    }
    // 查
    @Test
    public void selectByIdTest(){
        MyUser user = mapper.selectUserById(2);
        System.out.println(user);
    }
    // 改
    @Test
    public void updatePwdTest(){
        mapper.updatePassword(6,"123123");

    }





}
